#!/bin/bash
declare -i x=0
declare -i y=0
echo error 0 was expected
y+=1
java -jar GoodLine.jar  auravadima  rAAzhyGF
if (($? == 0)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 2 was expected
y+=1
java -jar GoodLine.jar  auravadima  rAAzhy
if (($? == 2)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 1 was expected
y+=1
java -jar GoodLine.jar  auravadim  rAAzhyGF
if (($? == 1)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 1 was expected
y+=1
java -jar GoodLine.jar  auravad  rAAzhdfssfsdf
if (($? == 1)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 0 was expected
y+=1
java -jar GoodLine.jar  vasya  qwerty  A.G.Y  READ
if (($? == 0)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 3 was expected
y+=1
java -jar GoodLine.jar  vasya  qwerty  A.G.Y  UNKNOWN
if (($? == 3)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 3 was expected
y+=1
java -jar GoodLine.jar  vasya  qwerty  ABG.TGB  UNKNOWN
if (($? == 3)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi
echo error 3 was expected
y+=1
java -jar GoodLine.jar  vasya  qwerty  ABG.TGB  UNKNOWN
if (($? == 3)) 
then
    echo SUCCESS
    x+=1
else 
echo FAILURE
fi

echo $x of $y