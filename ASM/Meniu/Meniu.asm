.model small
.data
executie db 'Executa secventa: 1, 2, 3 sau 4=stop: $'
mesaj1 db 0dh, 0ah, 'Se executa secventa 1.', 0dh, 0ah, '$'
mesaj2 db 0dh, 0ah, 'Se executa secventa 2.', 0dh, 0ah, '$'
mesaj3 db 0dh, 0ah, 'Se executa secventa 3.', 0dh, 0ah, '$'
tab_secv label word
dw secv1
dw secv2
dw secv3
dw gata
.code
start: mov ax, @data
mov ds, ax
iar: lea dx, executie ; solicita utilizatorului nr secv dorite
mov ah, 9
int 21h
mov ah, 1
int 21h
sub al, 31h ; transf interv 1..4 in 0..3
cmp al, 0 ; verif daca val citita este in interv 0..3
jc iar ; daca nu este in interv atunci
cmp al, 4 ; se resolicita o val de la utiliz
jnc iar
cbw ; extensie pe 16 biti
mov bx, ax
shl bx, 1 ; inmul cu 2 pt a se obtine adresa relativa
; in tabela cu adresele secventelor de exec
jmp word ptr tab_secv[bx]
secv1: lea dx, mesaj1
mov ah, 9
int 21h
jmp short iar
secv2: lea dx, mesaj2
mov ah, 9
int 21h
jmp short iar
secv3: lea dx, mesaj3
mov ah, 9
int 21h
jmp short iar
gata: mov ah,4ch
int 21h
.stack 20h
end start