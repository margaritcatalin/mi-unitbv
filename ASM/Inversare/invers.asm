.model small
.data
mesaj dw 'Ex', 'em', 'pl', 'u ', 'pr', 'og', 'ra', 'm ', '2$'
lung_mesaj equ ($-mesaj)/2
linie_noua db 0dh, 0ah, '$'
.code
start:
mov ax, @data
mov ds, ax
lea dx, mesaj
mov ah, 9
int 21h
lea dx, linie_noua
mov ah, 9
int 21h
lea si, mesaj
mov cx, lung_mesaj
iar: mov ax, [si]
xchg al, ah
mov [si], ax
add si, type mesaj
loop iar
lea dx, mesaj
mov ah, 9
int 21h
mov ax, 4c00h
int 21h
end start