.model small
.data
nr dw 0a2d3h
mesaj db '(16)A2D3 = (10)$'
.code
start:
mov ax, @data
mov ds, ax
lea dx, mesaj
mov ah, 9
int 21h
mov ax, [nr]
mov bx, 100 ; impartitor
mov dx, 0 ; extensie semn, deimpartit pozitiv
div bx ; dx = ultimile 2 cifre: zeci si unitati
mov cx, dx ; ax = primele 3 cifre, cx = ultimile 2 cifre
mov dx, 0 ; extensie semn, deimpartit pozitiv
div bx ; dx = cifre: mii, sute; ax = cifra zeci de mii
push dx ; se salveaza dx deoarece va fi modificat
add al, 30h ; se tipareste cifra zecilor de mii
mov dl, al
mov ah, 2
int 21h
pop ax ; se iau din stiva valorile pentru mii si sute
aam ; conversie la format zecimal neimpachetat
add ax, 3030h; conversie la cod ASCII
mov dx, ax ; se salveaza cele doua cifre
xchg dh, dl ; se tipareste cifra miilor
mov ah, 2
int 21h
xchg dh, dl ; se tipareste cifra sutelor
mov ah, 2
int 21h
mov ax, cx ; ultimile doua cifre: zeci, unitati
aam ; conversie la format zecimal neimpachetat
add ax, 3030h
mov dx, ax ; se salveaza cele doua cifre
xchg dh, dl ; se tipareste cifra zecilor
mov ah, 2
int 21h
xchg dh, dl ; se tipareste cifra unitatilor
mov ah, 2
int 21h
mov ah, 4ch
int 21h
end start