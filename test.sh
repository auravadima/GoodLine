#!/bin/bash
cd /home/auravadima/Desktop/git/GoodLine/out/production/GoodLine

declare -i x=0
declare -i y=0

test() {
  echo test $(( $y + 1)) error $1 was expected
  y+=1
  java -jar GoodLine.jar $2
  if (($? == $1))
  then
      echo SUCCESS
      x+=1
  else
  echo FAILURE
fi
}
#1
test 0 '-l auravadima -p rAAzhyGF'
#2
test 2 '-l auravadima -p qwertyui'
#3
test 1 '-l user -p rAAzhyGF'
#4
test 1 '-l user -p asdg'
#5
test 0 '-l vasya -p qwerty -role READ -res A.K.Y'
#6
test 4 '-l auravadima -p rAAzhyGF -res A.B -role EXECUTE'
#7
test 0 '-l vasya -p qwerty -res A.K.Y.innerFolder  -role READ'
#8
test 3 '-l auravadima -p rAAzhyGF -res ABG -role OPEN'
#9
test 2 '-l vasya -p rAAzhyGF -role OPEN -res GHY.IOP'
#10
test 0 '-l vasya -p qwerty -res A.K.Y.innerFolder.innerFolder -role READ'
#11
test 2 '-l vasya -p rAAzhyGF -role GHJK -res ABG.THG.TYU.innerFolder'
#12
test 1 '-l qwerty -p asdfg -role qwsd -res ABG.THG.TYU'
#13
test 4 '-l vasya -p qwerty -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res A.K.Y -role WRITE'
#14
test 3 '-l vasya -p qwerty -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res ABG.THG.TYU -role OPEN'
#15
test 5 '-l auravadima -p rAAzhyGF -ds not_Date -de not_Date -vol 12345 -res A.B -role WRITE'
#16
test 5 '-l auravadima -p rAAzhyGF -ds 2015-12-12 -de not_Date -vol 12345 -res A.B.C.D.E -role WRITE'
#17
test 4 '-l vasya -p qwerty -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res ABG -role WRITE'
#18
test 0 '-l vasya -p qwerty -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res A.K.Y -role READ'
#19
test 2 '-l auravadima -p qwerty -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res ABG.THG.TYU -role WRITE'
#20
test 1 '-l vadim -p rAAzhyGF -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res ABG.THG.TYU -role WRITE'
#21
test 5 '-l auravadima -p rAAzhyGF -ds 2015-12-12 -de 2015-12-12 -vol not_number -res A.B -role WRITE'
#22
test 0 '-l jdoe -p sup3rpaZZ -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res a.b -role WRITE'
#23
test 0 '-l jdoe -p sup3rpaZZ -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res a -role READ'
#24
test 0 '-l jrow -p Qweqrty12 -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res a.b.c -role EXECUTE'
#25
test 0 '-l jrow -p Qweqrty12 -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res a.bc -role EXECUTE'
#26
test 0 '-l jrow -p Qweqrty12 -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res a.bc.inner -role EXECUTE'
#27
test 0 '-l jrow -p Qweqrty12 -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res a.b.c.inner -role EXECUTE'
#28
test 5 '-l jrow -p Qweqrty12 -ds 2015-12-12 -de 2017-30-30 -vol 12345 -res a.b.c.inner -role EXECUTE'
#29
test 4 '-l jrow -p Qweqrty12 -ds 2015-12-12 -de 2015-12-12 -vol 12345 -res A.K.Y -role READ'
#30
test 0 '-l UWA -p HDP'
#31
test 4 '-l UWA -p HDP -res A.B -role WRITE'
#32
test 4 '-l UWA -p HDP -res . -role READ'

echo $x of $y
