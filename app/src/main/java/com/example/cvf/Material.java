package com.example.cvf;

import static org.apache.commons.math3.linear.MatrixUtils.createRealMatrix;
import static org.apache.commons.math3.linear.MatrixUtils.inverse;

/**
 * The Material class from which all material objects get their characteristics
 *
 * @author David Kosakowski, dkosakow@purdue.edu
 * @author Michael Bogdanor
 * @version 06/13/2019
 */
public class Material {
    private String name = "";
    private double youngsModulus1 = 0.0;    //Young's Modulus 1 (MPa)
    private double youngsModulus2 = 0.0;    //Young's Modulus 2 (MPa)
    private double youngsModulus3 = 0.0;    //Young's Modulus 3 (MPa)
    private double poissonsRatio12 = 0.0;   //Poisson's Ratio 12
    private double poissonsRatio13 = 0.0;   //Poisson's Ratio 13
    private double poissonsRatio23 = 0.0;   //Poisson's Ratio 23
    private double shearModulus12 = 0.0;    //Shear Modulus 12 (MPa)
    private double shearModulus13 = 0.0;    //Shear Modulus 13 (MPa)
    private double shearModulus23 = 0.0;    //Shear Modulus 23 (MPa)
    private double thermalExpansion1 = 0.0; //Coefficient of Thermal Expansion 1 (1/K)
    private double thermalExpansion2 = 0.0; //Coefficient of Thermal Expansion 2 (1/K)
    private double density = 0.0;           //Density (g/cc)
    private boolean allowEdit = false;      //allow user to edit, kind of like administrator privileges
    private SymmetryType symmetryType;      //Isotropic, Transverse, Orthotropic, or Anisotropic
    private FiberType fiberType;            //Fiber, Matrix, Filler, Other
    private double[][] elasticProperties;   //The basic elastic properties of the material
    private double[][] complianceTensor = new double[6][6];
    private double[][] stiffnessTensor = new double[6][6];

    public enum SymmetryType {
        //Constants
        ISOTROPIC("isotropic"),
        TRANSVERSE("transverse"),
        ORTHOTROPIC("orthotropic"),
        ANISOTROPIC("anisotropic");
        public final String symmetry;
        SymmetryType(String symmetry) {
            this.symmetry = symmetry;
        }   //label
    }   //Type

    public enum FiberType {
        //Constants
        FIBER("fiber"),
        FILLER("filler"),
        MATRIX("matrix"),
        OTHER("other");
        public final String type;
        FiberType(String type) {
            this.type = type;
        }   //label
    }   //Type

    public Material() {
        this.name = "New Material";
        fiberType = fiberType.OTHER;
    }   //empty constructor

    public FiberType getFiberType() {
        return this.fiberType;
    }   //getFiberType()

    public void setFiberType(FiberType fiberType) {
        this.fiberType = fiberType;
    }   //setFiberType

    Material(double[][] properties, SymmetryType symmetryType, FiberType fiberType, String name) {
        this.setName(name);
        this.setSymmetryType(symmetryType);
        this.setFiberType(fiberType);
        this.elasticProperties = properties.clone();
        if (symmetryType == SymmetryType.ORTHOTROPIC) {
            this.complianceTensor = this.computeTensor();
            this.stiffnessTensor = inverse(createRealMatrix(this.complianceTensor)).getData();
        } else {
            if (symmetryType == SymmetryType.ISOTROPIC) {
                setYoungsModulus1(properties[0][0]);
                setPoissonsRatio12(properties[0][1]);
                setThermalExpansion1(properties[0][2]);
                setDensity(properties[0][3]);
            } else if (symmetryType == SymmetryType.TRANSVERSE) {
                setYoungsModulus1(properties[0][0]);
                setYoungsModulus1(properties[0][1]);
                setPoissonsRatio12(properties[0][2]);
                setPoissonsRatio23(properties[0][3]);
                setShearModulus12(properties[0][4]);
                setThermalExpansion1(properties[0][5]);
                setThermalExpansion1(properties[0][6]);
                setDensity(properties[0][7]);
            }
            this.stiffnessTensor = this.computeTensor();
            this.complianceTensor = inverse(createRealMatrix(this.stiffnessTensor)).getData();
        }   //if orthotropic
    }   //full material constructor

    double[][] computeTensor() {
        double[][] tensor = new double[6][6];
        System.out.println(this.toString());
        if (this.elasticProperties.length == 6 && this.elasticProperties[0].length == 6) {
            tensor = this.elasticProperties;
        }   //if already a tensor?
        switch (this.symmetryType) {
            case ISOTROPIC:
                double young = this.elasticProperties[0][0];
                double poisson = this.elasticProperties[0][1];
                double factor = young / ((1 + poisson) * (1 - 2 * poisson));
                tensor[0][0] = factor * (1 - poisson);
                tensor[1][1] = tensor[0][0];
                tensor[2][2] = tensor[0][0];
                tensor[0][1] = factor * poisson;
                tensor[1][0] = tensor[0][1];
                tensor[0][2] = tensor[0][1];
                tensor[2][0] = tensor[0][1];
                tensor[1][2] = tensor[0][1];
                tensor[2][1] = tensor[0][1];
                tensor[3][3] = factor * (1 - 2 * poisson) / 2;
                tensor[4][4] = tensor[3][3];
                tensor[5][5] = tensor[3][3];
                break;
            case TRANSVERSE:
                double young1 = this.elasticProperties[0][0];
                double young2 = this.elasticProperties[0][1];
                double poisson12 = this.elasticProperties[0][2];
                double poisson23 = this.elasticProperties[0][3];
                double poisson21 = young2 * poisson12 / young1;
                double shear12 = this.elasticProperties[0][4];
                double delta = (1 + poisson23) * (1 - poisson23 - 2 * poisson21 * poisson12) / young2 / young2 / young1;
                tensor[1][1] = (1 - poisson21 * poisson12) / young2 / young1 / delta;
                tensor[1][2] = (poisson23 + poisson21 * poisson12) / young2 / young1 / delta;
                tensor[2][1] = tensor[1][2];
                tensor[1][0] = (poisson12 + poisson23 * poisson12) / young2 / young1 / delta;
                tensor[0][1] = (poisson21 + poisson23 * poisson21) / young2 / young2 / delta;
                tensor[2][2] = tensor[1][1];
                tensor[2][0] = (poisson12 + poisson23 * poisson12) / young1 / young2 / delta;
                tensor[0][2] = (poisson21 * (1 + poisson23)) / young2 / young2 / delta;
                tensor[0][0] = (1 - poisson23 * poisson23) / young2 / young2 / delta;
                tensor[3][3] = shear12;
                tensor[4][4] = shear12;
                tensor[5][5] = young2 / (1 + poisson23) / 2;
                break;
            case ORTHOTROPIC:
                young1 = this.elasticProperties[0][0];
                young2 = this.elasticProperties[0][1];
                double young3 = this.elasticProperties[0][2];
                poisson12 = this.elasticProperties[0][3];
                double poisson13 = this.elasticProperties[0][4];
                poisson23 = this.elasticProperties[0][5];
                shear12 = this.elasticProperties[0][6];
                double shear13 = this.elasticProperties[0][7];
                double shear23 = this.elasticProperties[0][8];
                tensor[0][0] = 1 / young1;
                tensor[1][1] = 1 / young2;
                tensor[2][2] = 1 / young3;
                tensor[0][1] = -poisson12 / young1;
                tensor[1][0] = tensor[0][1];
                tensor[0][2] = -poisson13 / young1;
                tensor[2][0] = tensor[0][2];
                tensor[1][2] = -poisson23 / young2;
                tensor[2][1] = tensor[1][2];
                tensor[3][3] = 1 / shear12;
                tensor[4][4] = 1 / shear13;
                tensor[5][5] = 1 / shear23;
                break;
            case ANISOTROPIC:
                int index = 0;
                for (int i = 0; i < this.elasticProperties.length; i++) {
                    for (int j = 0; j < this.elasticProperties[0].length; j++) {
                        tensor[i][j] = this.elasticProperties[0][index];
                        tensor[j][i] = tensor[i][j];
                        index += 1;
                    }   //for each column of each row
                }   //for each row
                break;
            default:
                System.out.println("DEFAULT CASE DEBUGGING,  NO SYMMETRY TYPE");
                break;
        }   //switch (type)
        return tensor;
    }   //computeTensor()

    //<editor-fold desc="Getters and Setters">
    public String getName() {
        return this.name;
    }   //getName()

    public void setName(String name) {
        this.name = name;
    }   //setName()

    public double getYoungsModulus1() {
        return this.youngsModulus1;
    }   //getYoungsModulus1()

    public void setYoungsModulus1(double youngsModulus1) {
        this.youngsModulus1 = youngsModulus1;
    }   //setYoungModulus1()

    public double getYoungsModulus2() {
        return youngsModulus2;
    }   //getYoungsModulus12()

    public void setYoungsModulus2(double youngsModulus2) {
        this.youngsModulus2 = youngsModulus2;
    }   //setYoungsModulus2()

    public double getYoungsModulus3() {
        return youngsModulus3;
    }   //getYoungModulus3()

    public void setYoungsModulus3(double youngsModulus3) {
        this.youngsModulus3 = youngsModulus3;
    }   //setYoungsModulus3()

    public double getPoissonsRatio12() {
        return poissonsRatio12;
    }   //getPoissonsRatio12()

    public void setPoissonsRatio12(double poissonsRatio12) {
        this.poissonsRatio12 = poissonsRatio12;
    }   //setPoissonsRatio12()

    public double getPoissonsRatio13() {
        return poissonsRatio13;
    }   //getPoissonsRatio13()

    public void setPoissonsRatio13(double poissonsRatio13) {
        this.poissonsRatio13 = poissonsRatio13;
    }   //setPoissonsRatio13()

    public double getPoissonsRatio23() {
        return poissonsRatio23;
    }   //getPoissonsRatio23()

    public void setPoissonsRatio23(double poissonsRatio23) {
        this.poissonsRatio23 = poissonsRatio23;
    }   //setPoissonsRatio23()

    public double getShearModulus12() {
        return shearModulus12;
    }   //getShearModulus12()

    public void setShearModulus12(double shearModulus12) {
        this.shearModulus12 = shearModulus12;
    }   //setShearModulus12()

    public double getShearModulus13() {
        return shearModulus13;
    }   //getShearModulus()

    public void setShearModulus13(double shearModulus13) {
        this.shearModulus13 = shearModulus13;
    }   //setShearModulus13()

    public double getShearModulus23() {
        return shearModulus23;
    }   //getShearModulus23()

    public void setShearModulus23(double shearModulus23) {
        this.shearModulus23 = shearModulus23;
    }   //setShearModulus23()

    public double getThermalExpansion1() {
        return thermalExpansion1;
    }   //getThermalExpansion1()

    public void setThermalExpansion1(double thermalExpansion1) {
        this.thermalExpansion1 = thermalExpansion1;
    }   //setThermalExpansion1()

    public double getThermalExpansion2() {
        return thermalExpansion2;
    }   //getThermalExpansion2()

    public void setThermalExpansion2(double thermalExpansion2) {
        this.thermalExpansion2 = thermalExpansion2;
    }   //setThermalExpansion2()

    public double getDensity() {
        return density;
    }   //getDensity()

    public void setDensity(double density) {
        this.density = density;
    }   //setDensity()

    public boolean isAllowEdit() {
        return allowEdit;
    }   //isAllowEdit()

    public void setAllowEdit(boolean allowEdit) {
        this.allowEdit = allowEdit;
    }   //setAllowEdit()

    public SymmetryType getSymmetryType() {
        return symmetryType;
    }   //getType()

    public void setSymmetryType(SymmetryType type) {
        this.symmetryType = type;
    }   //setType()
}   //Material