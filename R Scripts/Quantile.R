# wps.des: quantile, title = Quantile;
# wps.in: dataStr, string, DATA seperated by comma in one line;
# wps.in: v, string, threshold value for the predictor;
# wps.off;
dataStr=paste("0.007,0.0095,0.02,0.0495,0.041,0.00675,0.00825,0.00825,0.0025,0.00775,0.1855,1.0855,0.959,0.2455,",
           "0.212,0.032,0.0275,0.052,0.0615,0.372,1.164,0.8795,0.113,0.073,0.0275,0.00525,0.0025,0.00375,0.00375,",
           "0.0115,0.00825,0.13425,0.13425,0.00375,0.00375,0.01575,0.019,0.0615,38.7818,118.5957,0.028,0.1765,",
           "0.2335,0.098,0.032,0.00475,0.00375,0.00375,0.00825,0.00825,0.01875,0.0505,1.2594,1.1304,1.4036,",
           "0.0895,0.03,0.0145,0.081,0.119,0.054,0.0185,0.0215,0.022,0.1082,0.3216,0.0375,0.031,0.026,0.0335,",
           "0.1,0.0915,1.6029,0.0175,0.0235,0.098,0.093,0.01,0.0205,0.082,0.0695,0.014,0.1043,0.7626,0.02175,",
           "0.02225,0.033,0.0227,0.045,0.0045,0.0025,0.00425,0.181,0.356", sep="")
v = "0.2,0.4,0.8"
# wps.on;
#THIS FILE CONTAINS THE METHODS FOR RUNNING THE R SCRIPT

#1. IMPORT
# compdata=read.csv(datafile)
data=read.table(header=F, sep=",", text=dataStr )
q=read.table(header=F, sep=",", text=v)

res= quantile(data, t(q))

output = "quantileout"
write.table(res, output,col.names=F, row.names=F, sep=",")
# wps.out: output, text;