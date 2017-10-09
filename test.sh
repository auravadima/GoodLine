#!/bin/bash
declare -i x=0
declare -i y=0
echo error 0 was expected
y+=1
java -jar 123.jar -l auravadima -p rAAzhyGF
if (($? == 0)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 2 was expected
y+=1
java -jar 123.jar -l auravadima -p rAAzhy
if (($? == 2)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 1 was expected
y+=1
java -jar 123.jar -l auravadim -p rAAzhyGF
if (($? == 1)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 1 was expected
y+=1
java -jar 123.jar -l auravad -p rAAzhdfssfsdf
if (($? == 1)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 0 was expected
y+=1
java -jar 123.jar -l vasya -p qwerty -res ABG.THG.TYU -role WRITE
if (($? == 0)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 3 was expected
y+=1
java -jar 123.jar -l vasya -p qwerty -res ABG.THG.TYU -role UNKNOWN
if (($? == 3)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 3 was expected
y+=1
java -jar 123.jar -l vasya -p qwerty -res ABG.TGB -role UNKNOWN
if (($? == 3)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
fi
echo error 3 was expected
y+=1
java -jar 123.jar -l vasya -p qwerty -res ABG.TGB -role UNKNOWN
if (($? == 3)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi

echo $x of $y