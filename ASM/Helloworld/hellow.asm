.model small
.stack 10
.data
mesaj db 'Hello World! $'
.code
start:
mov ax, @data
mov ds, ax
mov dx, offset mesaj
mov ah, 9
int 21h
mov ax, 4c00h
int 21h
end start