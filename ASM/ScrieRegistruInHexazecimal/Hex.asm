.model small
.data
tab_conv db '0123456789ABCDEF'
nr dw ?
.code
start:
mov ax, @data
mov ds, ax
mov bx, 0fa3dh
mov nr, bx
mov ax, [nr]
and ah, 0f0h
lea bx, tab_conv
mov al, ah
mov cl, 4
shr al, cl
xlat tab_conv
mov dl, al
mov ah, 2
int 21h
mov ax, [nr]
and ah, 0fh
lea bx, tab_conv
mov al, ah
xlat tab_conv
mov dl, al
mov ah, 2
int 21h
mov ax, [nr]
and al, 0f0h
lea bx, tab_conv
mov cl, 4
shr al, cl
xlat tab_conv
mov dl, al
mov ah, 2
int 21h
mov ax, [nr]
and al, 0fh
lea bx, tab_conv
xlat tab_conv
mov dl, al
mov ah, 2
int 21h
mov ah, 4ch
int 21h
end start
