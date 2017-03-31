/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emergencyservices;

import emergencyservices.models.AreaModel;
import java.util.Vector;

/**
 *
 * @author Methun
 */
//import java.util.List;
public class Global {

    private static final int DHAKA_DIVISION = 2;
    static String dhakaDivsion[] = {"Dhaka", "Faridpur", "Gazipur", "Gopalganj", "Jamalpur", "Kishoreganj", "Madaripur", "Manikganj", "Munshiganj", "Mymensingh", "Narayanganj", "Narsingdi", "Netrakona", "Rajbari", "Shariatpur", "Sherpur", "Tangail"
    };
    static int dhakaDivisionId[] = {14, 16, 19, 20, 22, 29, 34, 36, 39, 40, 43, 44, 46, 53, 58, 59, 63};
    static String barisalDivision[] = {"Barguna", "Barisal", "Bhola", "Jhalokati", "Patuakhali", "Pirojpur"};
    static int barisalDivisionId[] = {3, 4, 5, 24, 51, 52};
    static String ChittagongDivision[] = {"Bandarban", "Brahmanbaria", "Chandpur", "Chittagong", "Comilla", "Cox's Bazar", "Feni", "Khagrachhari", "Lakshmipur", "Noakhali", "Rangamati"
    };
    static int ChittagongDivisionId[] = {2,
        7,
        8,
        10,
        12,
        13,
        17,
        27,
        32,
        48,
        55
    };
    static String KhulnaDivision[] = {"Bagerhat", "Chuadanga", "Jessore", "Jhenaidah", "Khulna", "Kushtia", "Magura", "Meherpur", "Narail", "Satkhira"
    };
    static int KhulnaDivisionId[] = {1,
        11,
        23,
        25,
        28,
        31,
        35,
        37,
        42,
        57
    };
    static String RajshahiDivision[] = {};
    static int RajshahiDivisionId[] = {};
    static String RangpurDivision[] = {};
    static int RangpurDivisionId[] = {};
    static String SylhetDivision[] = {};
    static int SylhetDivisionId[] = {};

    public static Vector getAllDivisionList() {
        Vector allDivisionList = new Vector();
        allDivisionList.addElement(new AreaModel(0, "Barisal Division"));
        allDivisionList.addElement(new AreaModel(1, "Chittagong Division"));
        allDivisionList.addElement(new AreaModel(DHAKA_DIVISION, "Dhaka Division"));
        allDivisionList.addElement(new AreaModel(3, "Khulna Division"));
        allDivisionList.addElement(new AreaModel(4, "Rajshahi Division"));
        allDivisionList.addElement(new AreaModel(5, "Rangpur Division"));
        allDivisionList.addElement(new AreaModel(6, "Sylhet Division"));
        return allDivisionList;
    }

    public static Vector getDistrictListByDivision(int divisonId) {
        Vector allDistrictList = new Vector();
        switch (divisonId) {
            case 0:
                for (int i = 0; i < barisalDivision.length; i++) {
                    allDistrictList.addElement(new AreaModel(barisalDivisionId[i], barisalDivision[i]));
                }
                break;
            case 1:
                for (int i = 0; i < ChittagongDivision.length; i++) {
                    allDistrictList.addElement(new AreaModel(ChittagongDivisionId[i], ChittagongDivision[i]));
                }
                break;
            case DHAKA_DIVISION:
                for (int i = 0; i < dhakaDivsion.length; i++) {
                    allDistrictList.addElement(new AreaModel(dhakaDivisionId[i], dhakaDivsion[i]));
                }


                break;
            case 3:
                for (int i = 0; i < KhulnaDivision.length; i++) {
                    allDistrictList.addElement(new AreaModel(KhulnaDivisionId[i], KhulnaDivision[i]));
                }
                break;
            case 4:
                for (int i = 0; i < 4; i++) {
                    allDistrictList.addElement(new AreaModel(dhakaDivisionId[i], dhakaDivsion[i]));
                }
                break;
            case 5:
                for (int i = 0; i < dhakaDivsion.length; i++) {
                    allDistrictList.addElement(new AreaModel(dhakaDivisionId[i], dhakaDivsion[i]));
                }
                break;


            case 6:

                for (int i = 0; i < dhakaDivsion.length; i++) {
                    allDistrictList.addElement(new AreaModel(dhakaDivisionId[i], dhakaDivsion[i]));
                }
                break;


            default:


        }

        return allDistrictList;
    }
}
