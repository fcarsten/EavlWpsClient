# wps.des: hpikde, title = Kernel Density Estimate;
# wps.in: nGclr3Cols, integer, Number of nGclr3Cols columns;
# wps.in: gclr3Str, string, gclr3Str DATA seperated by comma in one line;
# wps.in: nEvalptsCols, integer, Number of nEvalptsCols columns;
# wps.in: eps, string, evalptsStr DATA seperated by comma in one line;
# wps.off;
nGclr3Cols=3 #CHANGE IN EAVL TO SPECIFIC COLUMN SELECTION VIA GUI?
gclr3Str= paste("1.03532723603091,-2.58466138220659,4.55556523725497,",
                "0.901884915173719,-2.59847653846221,4.43875065807641,",

                "0.671293797597025,-2.20641306399104,2.76750179002311,",
                "0.771726323664565,-2.2459848566082,2.82454857906912,",
                "0.688413211183375,-2.11657503920197,2.92580895320887,",
                "0.918897153716298,-1.93685318710738,2.89044480607509,",
                "1.17367239635141,-1.85606716346943,2.83862885896737", sep="")

nEvalptsCols=3 #CHANGE IN EAVL TO SPECIFIC COLUMN SELECTION VIA GUI?
eps=gclr3Str

# wps.on;
#THIS FILE CONTAINS THE METHODS FOR RUNNING THE R SCRIPT
library(RJSONIO) #robust composition, missing data

#1. IMPORT
# compdata=read.csv(datafile)
gclr3Vector=read.table(header=F, sep=",", text=gclr3Str, na.strings=c("","NaN","NA"))
gclr3=data.frame(matrix(t(gclr3Vector), ncol=nGclr3Cols, byrow=TRUE))

evalptsVector=read.table(header=F, sep=",", text=eps, na.strings=c("","NaN","NA"))
evalpts=data.frame(matrix(t(evalptsVector), ncol=nEvalptsCols, byrow=TRUE))

#compdataImp=compdata 
gHpi=Hpi(gclr3,pilot="samse",pre="sphere")
gkde=kde(gclr3,gHpi,eval.points=evalpts)
res = toJSON(list("gHpi"=gHpi,"gkde"=gkde))

output = "hpikdeout"
write(res, output)
#zz = textConnection("outputStr", "w")
#write.csv(compdata, zz, row.names=FALSE)
#outputStrNN=paste(outputStr, sep="\\n")
# outputStr = textConnectionValue(zz)
# wps.out: output, text;