.model small
.data
n dw 17
fibo dw ?
.code
start:
mov ax, @data;
mov ds, ax
mov ax, 1
mov bx, 0
mov cx, N
mov di, bx
urm: mov si, ax
add ax, bx
mov bx, si
mov fibo[di], ax
add di, type fibo
loop urm
mov ah, 4ch
int 21h
end start