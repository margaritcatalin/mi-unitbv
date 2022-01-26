.model small
.stack 100h
.data
sir DB 80 DUP(0)
.code
mov bx, 0
mov dx, offset sir
mov cx, 80
mov ah, 3fh
int 21h
mov bx, offset sir
mov cx, ax ;cx contine lungimea sirului
mov ax, 0 ;ax devine 0
iteratie: ;in cx ramane numarul de cifre al numarului in baza 16
sub [bx], '0'
mov dx, 10
mul dx ;inmulteste continutul lui ax cu dx si memoreaza in dx
mov dh, 0
mov dl, [bx]
add ax, dx;la ax adauga continutul lui dx (respectiv dl)
add bx, 1 ;bx contine nr cifrelor care au fost prelucrate
sub cx, 1 ;cx se micsoreaza cu o unitate
cmp cx, 2 ;compara cx cu 2 deoarece la sir se mai adauga automat 2

jne iteratie
mov cx, 0 ;initializeaza registrul cx
mov bx, 8 ;baza de conversie
mov dx, 0 ;initializeaza registrul dx

ciclu1:
div bx ;imparte continutul lui ax la bx si retine restul in dx si catul
inc ax
push dx ;pune restul in stiva
mov dx, 0 ;initializeaza dx
add cx, 1 ;incrementeaza cx pentru a retine nr de elem din stiva
cmp ax, 0 ;daca in ax catul impartirii este 0 atunci iese din ciclu
jne ciclu1
mov bx, offset sir ;in bx muta adresa inceputului de sir
mov dx, cx ;dx va contine nr de resturi obtinute la impartire

ciclu2:
pop ax ;se extrage din stiva primul rest in ax
mov [bx], ax ;muta la adresa din bx continutul lui ax
add [bx], '0' ;transforma continutul de la adresa din bx in caracter
add bx, 1 ;incrementeaza bx
sub cx, 1 ;decrementeaza cx
cmp cx, 0 ;compara cx cu 0
jne ciclu2
mov cx, dx ;cx devine 0
mov bx, 1 ;deschide fisierul spre scriere
mov dx, offset sir ;dx contine adresa inceputului de sir
mov ah, 40h ;ah contine codul functiei de scriere
int 21h
mov ah, 4ch ;terminare
int 21h
end
