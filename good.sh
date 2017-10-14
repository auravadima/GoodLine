#!/bin/bash
cd /home/auravadima/Desktop/git/GoodLine/out/production/GoodLine
declare -i x=0
declare -i y=0
echo error 0 was expected
y+=1
java -jar GoodLine.jar  -l auravadima -p rAAzhyGF
if (($? == 0)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 2 was expected
y+=1
java -jar GoodLine.jar  -l auravadima -p qwertyui
if (($? == 2)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 1 was expected
y+=1
java -jar GoodLine.jar -l user -p rAAzhyGF
if (($? == 1)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 1 was expected
y+=1
java -jar GoodLine.jar  -l user -p asdg
if (($? == 1)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 0 was expected
y+=1
java -jar GoodLine.jar -l vasya -p qwerty -role READ -res A.K.Y 
if (($? == 0)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 4 was expected
y+=1
java -jar GoodLine.jar -l auravadima -p rAAzhyGF -res A.B -role EXECUTE
if (($? == 4)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 0 was expected
y+=1
java -jar GoodLine.jar -l vasya -p qwerty -res A.K.Y.innerFolder  -role READ
if (($? == 0)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 3 was expected
y+=1
java -jar GoodLine.jar -l auravadima -p rAAzhyGF -res ABG -role OPEN
if (($? == 3)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 2 was expected
y+=1
java -jar GoodLine.jar -l vasya -p rAAzhyGF -role OPEN -res GHY.IOP 
if (($? == 2)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 0 was expected
y+=1
java -jar GoodLine.jar -l vasya -p qwerty -res A.K.Y.innerFolder.innerFolder -role READ
if (($? == 0)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 2 was expected
y+=1
java -jar GoodLine.jar -l vasya -p rAAzhyGF -role GHJK -res ABG.THG.TYU.innerFolder
if (($? == 2)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 1 was expected
y+=1
java -jar GoodLine.jar -l qwerty -p asdfg -role qwsd -res ABG.THG.TYU
if (($? == 1)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 4 was expected
y+=1
java -jar GoodLine.jar -l vasya -p qwerty -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res A.K.Y -role WRITE
if (($? == 4)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 3 was expected
y+=1
java -jar GoodLine.jar -l vasya -p qwerty -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res ABG.THG.TYU -role OPEN
if (($? == 3)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 5 was expected
y+=1
java -jar GoodLine.jar -l auravadima -p rAAzhyGF -ds not_Date -de not_Date -vol 12345 -res A.B -role WRITE
if (($? == 5)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 5 was expected
y+=1
java -jar GoodLine.jar -l auravadima -p rAAzhyGF -ds 2015-12-12 -de not_Date -vol 12345 -res A.B.C.D.E -role WRITE
if (($? == 5)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 4 was expected
y+=1
java -jar GoodLine.jar -l vasya -p qwerty -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res ABG -role WRITE
if (($? == 4)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 0 was expected
y+=1
java -jar GoodLine.jar -l vasya -p qwerty -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res A.K.Y -role READ
if (($? == 0)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 2 was expected
y+=1
java -jar GoodLine.jar -l auravadima -p qwerty -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res ABG.THG.TYU -role WRITE
if (($? == 2)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 1 was expected
y+=1
java -jar GoodLine.jar -l vadim -p rAAzhyGF -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res ABG.THG.TYU -role WRITE
if (($? == 1)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 5 was expected
y+=1
java -jar GoodLine.jar -l auravadima -p rAAzhyGF -ds 2015-12-12 -de 2015-12-12 -vol not_number -res A.B -role WRITE
if (($? == 5)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 0 was expected
y+=1
java -jar GoodLine.jar -l jdoe -p sup3rpaZZ -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res a.b -role WRITE
if (($? == 0)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 0 was expected
y+=1
java -jar GoodLine.jar -l jdoe -p sup3rpaZZ -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res a -role READ
if (($? == 0)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 0 was expected
y+=1
java -jar GoodLine.jar -l jrow -p Qweqrty12 -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res a.b.c -role EXECUTE
if (($? == 0)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 0 was expected
y+=1
java -jar GoodLine.jar -l jrow -p Qweqrty12 -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res a.bc -role EXECUTE
if (($? == 0)) 
then
    echo SUCCESS
    x+=1
else 
echo $?
echo FAILURE
fi
echo error 0 was expected
y+=1
java -jar GoodLine.jar -l jrow -p Qweqrty12 -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res a.bc.inner -role EXECUTE
if (($? == 0)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 0 was expected
y+=1
java -jar GoodLine.jar -l jrow -p Qweqrty12 -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res a.b.c.inner -role EXECUTE
if (($? == 0)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo $x of $y