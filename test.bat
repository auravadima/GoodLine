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
echo %x% of %y%
PAUSE