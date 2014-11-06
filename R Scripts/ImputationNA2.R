# wps.des: impna2, title = Imputation NA 2;
# wps.in: nCols, integer, Number of columns;
# wps.in: dataStr, string, DATA seperated by comma in one line;
# wps.off;
nCols=5 #CHANGE IN EAVL TO SPECIFIC COLUMN SELECTION VIA GUI?
dataStr="1,2,3,4,5,6,7,8,9,10,11,12,13,14,15"
# wps.on;
#THIS FILE CONTAINS THE METHODS FOR RUNNING THE R SCRIPT
library(robCompositions) #robust composition, missing data

#1. IMPORT
# compdata=read.csv(datafile)
dataVector=read.table(header=F, sep=",", text=dataStr)
data=matrix(dataVector, nrow=length(dataVector)/nCols, ncol = nCols, byrow=T)
#2. PREPROCESSING

#2.1. this version does not do DL substitution
#FOR EAVL WE CAN ASK THE USER TO SUPPLY THE DL SUBSITITUTION VALUE FOR EACH COLUMN, IF REQUIRED

#2.2. replace missing at random NA's (first specify the columns containing compositional data)
# THE READ.CSV METHOD OF R AUTOMATICALLY ASSIGNS NA TO BLANK CELLS
# FOR EAVL THE USER NEEDS TO INDICATE THESE COLUMNS
# xyz=compdata[,66:68] # the columns containing geographic location i.e. (x,y,z)
#IF USING GUI SELECTION I WILL REWRITE imputationNA() METHOD
compdataImp=impKNNa(data) #THIS IS A SLOW STEP
#compdataImp=compdata 

output = "impnaout"
write.table(compdataImp$xImp, output,row.names=FALSE, sep=",", col.names=FALSE)
#zz = textConnection("outputStr", "w")
#write.csv(compdata, zz, row.names=FALSE)
#outputStrNN=paste(outputStr, sep="\\n")
# outputStr = textConnectionValue(zz)
# wps.out: output, text;