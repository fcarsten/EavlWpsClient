# wps.des: doubleLogDensity, title = Double Log Density;
# wps.in: dataStr, string, DATA seperated by comma in one line;
# wps.in: v, double, threshold value for the predictor;
# wps.off;
dataStr=paste("0.007,65.34",
              "0.0095,59.795",
 
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