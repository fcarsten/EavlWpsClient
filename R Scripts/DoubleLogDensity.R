# wps.des: doubleLogDensity, title = Double Log Density;
# wps.in: dataStr, string, DATA seperated by comma in one line;
# wps.in: v, threshold value for the predictor
# wps.off;
dataStr=paste("0.007,65.34",
              "0.0095,59.795",
              "0.02,47.02",
              "0.0495,52.34",
              "0.041,78.59",
              "0.00675,93.95",
              "0.00825,86.365",
              "0.00825,71.615",
              "0.0025,57.69",
              "0.00775,55.095",
              "0.1855,69.515",
              "1.0855,66.875",
              "0.959,56.965",
              "0.2455,52.115",
              "0.212,49.405",

              "0.045,39.194",
              "0.0045,34.836",
              "0.0025,41.4",
              "0.00425,38.425",
              "0.181,51.38",
              "0.356,68.49", sep=",")
v=0.437
# wps.on;
#THIS FILE CONTAINS THE METHODS FOR RUNNING THE R SCRIPT
#1. IMPORT
# compdata=read.csv(datafile)
dataVector=read.table(header=F, sep=",", text=dataStr)
#inData=data.frame(matrix(dataVector,  ncol = 2, byrow=T))
inData = data.frame(x = unlist(dataVector[ , c(TRUE, FALSE)]), y = unlist(dataVector[ , c(FALSE, TRUE)]))

predictCol=1
elementCol=2

all=density(log(inData[,elementCol]))
high = density(log(subset(inData[,elementCol],inData[,predictCol]>=v)))

result = cbind(all$x, all$y, high$x, high$y)

output = "doublelogdensityout"
write.table(result, output,row.names=FALSE, sep=",", col.names=FALSE)
#zz = textConnection("outputStr", "w")
#write.csv(compdata, zz, row.names=FALSE)
#outputStrNN=paste(outputStr, sep="\\n")
# outputStr = textConnectionValue(zz)
# wps.out: output, text;