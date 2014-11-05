package org.auscope.eavl.wpsclient;

import java.io.*;

import org.n52.wps.client.*;

/**
 * Hello world!
 *
 */
public class App {
    final static String IMPUTATION_NA_DATA = "holeid,from,to,Au_assay,As,Ag_ppm,Bi_ppm,Cr_ppm,Cu_ppm,Mo_ppm,Pb_ppm,Sb_ppm,Sc_ppm,Te_ppm,Th_ppm,V_ppm,W_ppm,Zn_ppm,Zr_ppm,Ba_ppm,Be_ppm,Cd_ppm,Ce_ppm,Cs_ppm,Co_ppm,Ga_ppm,Hf_ppm,Ind_ppm,Li_ppm,Lu_ppm,Nb_ppm,Ni_ppm,Rb_ppm,Sn_ppm,Sr_ppm,Ta_ppm,Tb_ppm,Tl_ppm,U_ppm,Y_ppm,Yb_ppm,Al2O3_pct,C_ppm,CaO_pct,Dy_ppm,Er_ppm,Eu_ppm,Gd_ppm,Fe2O3_pct,Ge_ppm,Ho_ppm,K2O_pct,LOI_pct,MgO_pct,MnO_pct,Na2O_pct,Nd_ppm,P2O5_pct,Pr_ppm,Re_ppm,SiO2_pct,Sm_ppm,Tm_ppm,TiO2_pct,SO3_pct,mid_x,mid_y,mid_z\n"
            + "UGD1944,0,0.5,0.007,34,0.16,2.44,2208,152,0.6,4.4,1.75,27.6,0.89,3.82,151,0.7,204,60.9,980,0.55,0.18,38.54,58.27,98.7,9.18,1.58,0.046,20.6,0.134,2.35,812,65.34,0.4,310.93,0.24,0.344,1.12,0.59,7.3,0.71,7.64,13000,6.25,1.6,0.77,0.98,2.66,15.32,1.12,0.29,1.58,6.73,8.48,0.4,0.62,18.42,0.152,4.642,0.001,49.53,3.33,0.18,0.45,3.14,49904.09054,99301.31593,1803.625906\n"
            + "UGD1944,0.5,1.5,0.0095,30.95,0.155,8.62,2054.5,153,0.7,5.45,1.805,26.9,4.74,3.525,142.5,0.8,205,57.1,959.5,0.64,0.24,35.625,58.15,93.2,8.4,1.505,0.0605,18.65,0.1165,2.065,793.5,59.795,0.5,344.84,0.22,0.328,1.1,0.565,7.01,0.7,7.055,14200,7.3,1.535,0.755,0.915,2.49,15.72,1.1,0.29,1.415,7.185,8.94,0.415,0.54,17.105,0.1435,4.3415,0.0015,48.47,3.045,0.145,0.42,3.055,49904.65638,99301.33069,1803.133853\n"
            + "UGD1941R,320.5,321,0.356,64.8,0.11,0.41,362,83,8.2,7.4,3.31,15.9,0.15,3.91,117,8.8,28,124.5,478.4,1.1,0.04,45.41,8.31,26,17.55,3.27,0.012,49.5,0.202,2.87,160,68.49,0.5,312.5,0.28,0.388,0.93,1.03,11.04,1.3,15.42,10000,4.51,2.21,1.39,1.03,2.98,6.54,1.37,0.4,1.42,4.93,1.07,0.06,2.97,19.44,0.185,5.267,0.001,61.44,3.67,0.19,0.59,2.2,50140.65873,99326.89138,1575.067961\n";

    final static String LOG_DENSITY_DATA = "2208,2054.5,1754.5,1627.5,2011";

    public static void main(String[] args) {
        ConditionalProbabilityWpsClient client = new ConditionalProbabilityWpsClient(
                "http://130.56.250.15:8080/wps/WebProcessingService");
        try {
          //  System.out.println(client.imputationNA(5, 65, IMPUTATION_NA_DATA));
            String[] res = client.logDensity(LOG_DENSITY_DATA);
            System.out.println("X: "+res[0]);
            System.out.println("Y: "+res[1]);

        } catch (WPSClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
