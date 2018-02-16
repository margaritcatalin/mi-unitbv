seg_date segment
tab_conv db '0123456789ABCDEF'
mesaj db '- are codul ASCII: '
tasta db 2 dup (?), 0dh, 0ah, '$'
seg_date ends
seg_cod segment
assume cs: seg_cod, ds: seg_date
start:
mov ax, seg_date
mov ds, ax
mov ah, 1 ; citeste cu ecou o tasta
int 21h
mov ah,al ; salveaza codul tastei
lea bx, tab_conv; initializeaza bx pentru xlat
and al, 0fh ; se retine numai al doilea grup de 4 biti
xlat tab_conv ; codul ASCII al acestui grup de 4 biti este
mov tasta+1, al ; a doua cifra a codului
mov al, ah ; codul initial al tastei
mov cl, 4 ; numara deplasarile la dreapta
shr al, cl ; deplasare logica la dreapta cu 4 biti
xlat tab_conv ; conversia primului grup de 4 biti
mov tasta, al ; codul ASCII al primului grup de 4 biti
lea dx, mesaj
mov ah, 9 ; tipareste codul tastei
int 21h
mov ax,4c00h ; revenire in DOS
int 21h
seg_cod ends
end start