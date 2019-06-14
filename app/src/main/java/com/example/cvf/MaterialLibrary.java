package com.example.cvf;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * The MaterialLibrary hosts the data for all the default materials and instantiates an ArrayList of materials to use
 *
 * @author David Kosakowski, dkosakow@purdue.edu
 * @version 06/14/2019
 */
class MaterialLibrary {
    //E1    v12     a1      density
    private static double[] epoxy = {3500, 0.33, 0.55e-6, 1.54};
    private static double[] classAPVE = {2750, 0.33, 80e-6, 1.17};
    private static double[] vinylEster = {3600, 0.33, 80e-6, 1.166};
    private static double[] polyester = {2500, 0.33, 124e-6, 1.37};
    private static double[] pps = {5000, 0.33, 60e-6, 1.44};
    private static double[] abs = {2500, 0.33, 80e-6, 1.07};
    private static double[] pet = {2900, 0.33, 70e-6, 1.38};
    private static double[] nylon = {2500, 0.33, 110e-6, 1.15};
    private static double[] peek = {4000, 0.37, 55e-6, 1.32};
    private static double[] eGlass = {72e3, 0.2, 5e-6, 2.55};
    private static double[] sGlass = {86e3, 0.22, 5.5e-6, 2.55};
    private static double[] basalt = {86e3, 0.25, 2.5e-6, 2.67};
    //E1    E2      G12     v12     v23     a1      a2      density
    private static double[] carbon = {257e3, 12450, 25e3, 0.291, 0.206, 2e-6, 5e-6, 1.8};
    private static double[] a42 = {240e3, 12450, 25e3, 0.291, 0.206, 2e-6, 5e-6, 1.78};
    private static double[] grafil70034 = {234e3, 12450, 25e3, 0.291, 0.206, 2e-6, 5e-6, 1.8};
    private static double[] kevlar = {154e3, 4200, 2900, 0.35, 0.3, -4e-6, -4e-6, 1.47};

    //<editor-fold desc="Default Materials & Properties">
    private static Material Epoxy = new Material(epoxy, Material.Type.ISOTROPIC, "Epoxy");
    private static Material ClassAPVE = new Material(classAPVE, Material.Type.ISOTROPIC, "Class A PVE");
    private static Material VinylEster = new Material(vinylEster, Material.Type.ISOTROPIC, "Vinyl Ester");
    private static Material Polyester = new Material(polyester, Material.Type.ISOTROPIC, "Polyester");
    private static Material PPS = new Material(pps, Material.Type.ISOTROPIC, "PPS");
    private static Material ABS = new Material(abs, Material.Type.ISOTROPIC, "ABS");
    private static Material PET = new Material(pet, Material.Type.ISOTROPIC, "PET");
    private static Material Nylon = new Material(nylon, Material.Type.ISOTROPIC, "Nylon");
    private static Material Peek = new Material(peek, Material.Type.ISOTROPIC, "Peek");
    private static Material EGlass = new Material(eGlass, Material.Type.ISOTROPIC, "E-Glass");
    private static Material SGlass = new Material(sGlass, Material.Type.ISOTROPIC, "S-Glass");
    private static Material Basalt = new Material(basalt, Material.Type.ISOTROPIC, "Basalt");

    private static Material Carbon = new Material(carbon, Material.Type.TRANSVERSE, "Carbon");
    private static Material A42 = new Material(a42, Material.Type.TRANSVERSE, "A42");
    private static Material Grafil70034 = new Material(grafil70034, Material.Type.TRANSVERSE, "Grafil 700-34");
    private static Material Kevlar = new Material(kevlar, Material.Type.TRANSVERSE, "Kevlar");
    //</editor-fold>

    public static ArrayList<Material> materialList = new ArrayList<Material>() {{
        add(Epoxy); add(ClassAPVE); add(VinylEster); add(Polyester); add(PPS);
        add(ABS); add(PET); add(Nylon); add(Peek); add(EGlass); add(SGlass);
        add(Basalt); add(Carbon); add(A42); add(Grafil70034); add(Kevlar);
    }};
}   //MaterialLibrary.java
