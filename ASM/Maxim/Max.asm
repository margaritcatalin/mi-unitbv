.model small
.stack 10h
.data
sir db 10, 20, -30, 100, -100, 200
lung dw $-sir
max db ?
MesSirVid db 'Sirul nu are valori incarcate.$'
.code
mov ax, @data
mov ds, ax
mov cx, lung ; contor = nr val din sir
jcxz sir_vid ; daca sir vid atunci salt la etich
sir_vid
lea si, sir
cld ; Clear Direction Flag
mov bl, [si] ; init max cu primul elem din sir
inc si
dec cx
jcxz gata
iar: lodsb ; citeste elem crt din sir
cmp bl, al
jge urm
mov bl, al
urm: loop iar
gata: mov max, bl
iesire: mov ah, 4ch
int 21h
sir_vid:lea dx, MesSirVid
mov ah, 9
int 21h
jmp iesire
end