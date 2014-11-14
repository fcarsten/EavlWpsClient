# wps.des: cenlr, title = Centred log-ratio transformation;
# wps.in: nCols, integer, Number of columns;
# wps.in: dataStr, string, DATA seperated by comma in one line;
# wps.off;
nCols=5 #CHANGE IN EAVL TO SPECIFIC COLUMN SELECTION VIA GUI?
dataStr="640.0,328.0,NA,169.0,196.0,1800.0,484.0,515.0,2291.0,912.0,2085.0,445.0,725.0,8373.0,1732.0,616.0,331.0,126.0,117.0,149.0,875.0,368.0,191.0,290.0,275.0,770.0,364.0,196.0,242.0,236.0,990.0,415.0,284.0,588.0,420.0,414.0,305.0,94.0,68.0,112.0,1394.0,440.0,393.0,1161.0,636.0,1285.0,374.0,363.0,785.0,487.0,1102.0,469.0,243.0,496.0,388.0,1717.0,452.0,452.0,1977.0,832.0,1549.0,454.0,424.0,1345.0,676.0,838.0,386.0,155.0,208.0,222.0,845.0,386.0,211.0,317.0,280.0,1130.0,394.0,271.0,490.0,386.0,1765.0,466.0,524.0,2133.0,822.0,1195.0,443.0,329.0,974.0,523.0,2180.0,521.0,553.0,2781.0,1010.0,1017.0,410.0,225.0,419.0,345.0"
# wps.on;
#THIS FILE CONTAINS THE METHODS FOR RUNNING THE R SCRIPT
library(robCompositions) #robust composition, missing data

#1. IMPORT
# compdata=read.csv(datafile)
dataVector=read.table(header=F, sep=",", text=dataStr, na.strings=c("","NaN","NA"))
data=data.frame(matrix(t(dataVector), ncol=nCols, byrow=TRUE))
#data=data.frame(matrix(dataVector, nrow=length(dataVector)/nCols, ncol = nCols, byrow=T))
#2. PREPROCESSING

#2.1. this version does not do DL substitution
#FOR EAVL WE CAN ASK THE USER TO SUPPLY THE DL SUBSITITUTION VALUE FOR EACH COLUMN, IF REQUIRED

#2.2. replace missing at random NA's (first specify the columns containing compositional data)
# THE READ.CSV METHOD OF R AUTOMATICALLY ASSIGNS NA TO BLANK CELLS
# FOR EAVL THE USER NEEDS TO INDICATE THESE COLUMNS
# xyz=compdata[,66:68] # the columns containing geographic location i.e. (x,y,z)
#IF USING GUI SELECTION I WILL REWRITE imputationNA() METHOD
compdataImp=cenLR(data)
(data) #THIS IS A SLOW STEP
#compdataImp=compdata 

output = "cenlrout"
write.table(compdataImp$x.clr, output,row.names=FALSE, sep=",", col.names=FALSE)
#zz = textConnection("outputStr", "w")
#write.csv(compdata, zz, row.names=FALSE)
#outputStrNN=paste(outputStr, sep="\\n")
# outputStr = textConnectionValue(zz)
# wps.out: output, text;