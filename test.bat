@echo off
cd %CD% 
set /a x = 0
set /a y = 0
echo error 0 was expected
set /a y += 1
java -jar 123.jar -l auravadima -p rAAzhyGF
if %ERRORLEVEL% == 0 (
    echo SUCCESS
    set /a x+=1
) else (echo FAILURE)
echo.
echo error 2 was expected
set /a y += 1
java -jar 123.jar -l auravadima -p rAAzhy
if %ERRORLEVEL% == 2 (
    echo SUCCESS
    set /a x+=1
) else (echo FAILURE)
echo.
echo error 1 was expected
set /a y += 1
java -jar 123.jar -l auravadim -p rAAzhyGF
if %ERRORLEVEL% == 1 (
    echo SUCCESS
    set /a x+=1
) else (echo FAILURE)
echo.
echo error 1 was expected
set /a y += 1
java -jar 123.jar -l auravad -p rAAzhdfssfsdf
if %ERRORLEVEL% == 1 (
    echo SUCCESS
    set /a x+=1
) else (echo FAILURE)
echo.
echo error 0 was expected
set /a y += 1
java -jar 123.jar -l vasya -p qwerty -res ABG.THG.TYU -role WRITE
if %ERRORLEVEL% == 0 (
    echo SUCCESS
    set /a x+=1
) else (echo FAILURE)
echo.
echo error 3 was expected
set /a y += 1
java -jar 123.jar -l vasya -p qwerty -res ABG.THG.TYU -role UNKNOWN
if %ERRORLEVEL% == 3 (
    echo SUCCESS
    set /a x+=1
) else (echo FAILURE)
echo.
echo error 0 was expected
set /a y += 1
java -jar 123.jar -l vasya -p qwerty -res ABG.THG.TYU.innerFolder -role WRITE
if %ERRORLEVEL% == 0 (
    echo SUCCESS
    set /a x+=1
) else (echo FAILURE)
echo.
echo error 3 was expected
set /a y += 1
java -jar 123.jar -l vasya -p qwerty -res ABG.TGB -role UNKNOWN
if %ERRORLEVEL% == 3 (
    echo SUCCESS
    set /a x+=1
) else (echo FAILURE)
echo.
echo %x% of %y%
PAUSE