add_data segment
numar_1 dw 0a8adh, 7fe2h, 0a876h, 0
lung_nr1 equ ($ - numar_1)/2
numar_2 dw 0cdefh, 52deh, 378ah, 0
add_data ends
multibyte_add segment
assume cs:multibyte_add, ds: add_data
start:
mov ax, add_data ; init reg ds
mov ds, ax ; cu adresa de segment
mov cx, lung_nr1 ; contor = lungime nr1
mov si, 0 ; init index de elem
clc ; (cf) = 0 transportul initial
bucla:
mov ax, numar_2[si]
adc numar_1[si], ax
inc si ; actualiz index de elem
inc si
loop bucla
mov ax, 4c00h ; revenire in DOS
int 21h
multibyte_add ends
end start
