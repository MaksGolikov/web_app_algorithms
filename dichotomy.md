
# Dichotomy method
Spring boot application 

Crated by ***Maks Golikov***
## Algorithm of dichotomy method

[link to class "DichotomyServiceImpl" where the algorithm was implemented](./src/main/java/com/example/demo/service/impl/DichotomyServiceImpl.java)

1. check root isolation interval
    - we start checking from the second iteration
    - if f(x) previous from list of f(x) on each iteration < 0 , and 
    f(x) now > 0, or vice versa, then we found intervals where exists roots

2. after that we find the root on each interval
    - on first iteration define variables 
    "left" and "right" "boarders", "x" that equals (left+right)/2
    "f(a)" and "f(x)" , and "multiple" f(x) and f(a) 
    - on second and other iteration we define "left border" the "x"
     if multiple >=0  and define "right border" the "x" if multiple<0,
    - we make calculation while modulus f(x) < epsilon,
    where epsilon it is our accuracy that equals 0,0001
8. show result
   - [link to screenshots 1 with variant 9(working program)](https://drive.google.com/file/d/1goMUc9jQmoF3TpUyMhSMCtZlY4PHYDjq/view?usp=sharing)
   - [link to screenshots 2 with variant 9(working program)](https://drive.google.com/file/d/1mVgs9Wl9_WN7zaZHCMwHmayrgAkUO0ym/view?usp=sharing)
   - [link to screenshots 3 with variant 9(working program)](https://drive.google.com/file/d/14VZIKDfjDbxhRcspCG33aru4oQA4qBpY/view?usp=sharing)