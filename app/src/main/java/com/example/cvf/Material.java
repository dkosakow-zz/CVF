package com.example.cvf;

import java.util.ArrayList;
import java.util.jar.Attributes;

/**
 *  The Material class from which all material objects get their characteristics
 *
 * @author: David Kosakowski, dkosakow@purdue.edu
 * @version: 06/13/2019
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
    private Type type;                      //Isotropic, Transverse, Orthotropic, or Anisotropic
    private double[] elasticProperties;
    private double[][] complianceTensor = new double[6][6];
    private double[][] stiffnessTensor = new double[6][6];

    public enum Type {
        //Constants
        ISOTROPIC("isotropic"),
        TRANSVERSE("transverse"),
        ORTHOTROPIC("orthotropic"),
        ANISOTROPIC("anisotropic");
        public final String label;
        private Type(String label) {
            this.label = label;
        }   //label
    }   //Type

    public Material() {
        this.name = "New Material";
    }   //empty constructor

    public Material(double[] properties, Type type, String name) {
        this.setName(name);
        this.elasticProperties = properties.clone();
        switch(type) {
            case ISOTROPIC:

                break;
            case TRANSVERSE:

                break;
            case ORTHOTROPIC:

                break;
            case ANISOTROPIC:

                break;
        }   //switch (type)
    }   //full material constructor

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

    public Type getType() {
        return type;
    }   //getType()

    public void setType(Type type) {
        this.type = type;
    }   //setType()
    //</editor-fold>

//    public double[] computeTensor() {
//
//        return new double[];
//    }   //computeTensor

    public boolean addMaterial(String name) {
        boolean wasSuccessful = false;
        //TODO
        return wasSuccessful;
    }   //addMaterial()
}   //class Material