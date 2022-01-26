.model small
.stack 100h
.data
lung_var equ 1
var dw lung_var dup (0acfh)
nr_1 db ?
.code
assume cs: @code, ds: @data
start:
mov ax, @data
mov ds, ax
mov si, 0 ; index curent pentru cuvintele din variabila
mov dl, lung_var ; contor nr cuvinte
mov bl, 0 ; contor nr de 1 gasiti
bucla2:
mov cx, 16 ; contorul de biti pentru un cuvant
mov ax, var[si] ; se citeste cuvantul curent
bucla1:
rcl ax, 1 ; o rotatie pentru a deplasa un bit
adc bl, 0 ; se contorizeaza nr de 1 dintr-un cuvant
loop bucla1
add si, type var ; se actualizeaza indexul
dec dl ; se testeaza daca mai sunt cuvinte
jnz bucla2 ; daca da, se reia citirea cuvintelor
mov nr_1, bl ; daca nu, se depune rezultatul
mov ax, 4c00h
int 21h
end start