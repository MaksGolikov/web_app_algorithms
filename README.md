# Iteration method
Spring boot application 

Crated by ***Maks Golikov***
## Algorithm of iteration method

[link to class "CalculationUtil" where the algorithm was implemented](./src/main/java/com/example/demo/util/CalculationUtil.java)

1. create arr of coefficient
2. make copy of arr
3. create arr of answer
4. check determinant
5. check "условние преобладания"
6. create some temp lists
7. calculation
    - make an infinite loop with an exit condition when
     the precision has been reached
    - we carry out calculations in accordance with the formula - 
    [link to formula](https://drive.google.com/file/d/1UINM950iR_LI96LftP4WOgh5yARuljWa/view?usp=sharing)
    - after that, check second and subsequent iteration and checking accuracy
    - If the accuracy has been achieved, then we write the "x" from the main diagonal into the array with the answer
8. show result
    