# wps.des: meanACF, title = Mean Autocorrelation;
# wps.in: dataStr, string, DATA seperated by comma in one line;
# wps.off;
dataStr=paste("UGD1944,65.34,UGD1944,59.795,UGD1944,47.02,UGD1944,52.34,UGD1944,78.59,UGD1944,93.95,UGD1944,86.365,UGD1944,71.615,UGD1944,57.69,",
              "UGD1939R,107.07,UGD1939R,32.07,UGD1939R,0.895,UGD1939R,2.225,UGD1939R,2.755,UGD1939R,2.135,UGD1939R,3.16,UGD1939R,4.02", sep="")
# wps.on;
#THIS FILE CONTAINS THE METHODS FOR RUNNING THE R SCRIPT

holeidCol=1
elementCol=2
#1. IMPORT
# compdata=read.csv(datafile)
d=read.table(header=F, sep=",", text=dataStr)
#data=matrix(dataVector, nrow=length(dataVector)/2, ncol = 2, byrow=T)
data= data.frame(holeId = unlist(d[ , c(TRUE, FALSE)]), value = unlist(d[ , c(FALSE, TRUE)]))
#2. PREPROCESSING

holeid_all = unique(data[,holeidCol])
nH=length(holeid_all)
lag=20
acfAll=matrix(data=NA,nrow=nH,ncol=lag)
ci=rep(NA,nH)
for (h in 1:nH) {
  dhe=subset(data[,elementCol],data$holeId==holeid_all[h])
  acfe=as.vector(acf(dhe,plot=FALSE)$acf)
  acfAll[h,]=acfe[1:lag]
  ci[h]=2/(sqrt(length(dhe)))
}
acfMean=colMeans(acfAll)
ciMean=mean(ci)
compdata = list(acf=acfMean,ci=ciMean)

output = "meanacfout"
write.table(compdata, output,row.names=FALSE, sep=",", col.names=FALSE)
#zz = textConnection("outputStr", "w")
#write.csv(compdata, zz, row.names=FALSE)
#outputStrNN=paste(outputStr, sep="\\n")
# outputStr = textConnectionValue(zz)
# wps.out: output, text;