
babyrev:     file format elf64-x86-64


Disassembly of section .init:

0000000000001000 <.init>:
    1000:	f3 0f 1e fa          	endbr64 
    1004:	48 83 ec 08          	sub    $0x8,%rsp
    1008:	48 8b 05 d9 2f 00 00 	mov    0x2fd9(%rip),%rax        # 3fe8 <exit@plt+0x2ed8>
    100f:	48 85 c0             	test   %rax,%rax
    1012:	74 02                	je     1016 <__cxa_finalize@plt-0x8a>
    1014:	ff d0                	callq  *%rax
    1016:	48 83 c4 08          	add    $0x8,%rsp
    101a:	c3                   	retq   

Disassembly of section .plt:

0000000000001020 <.plt>:
    1020:	ff 35 6a 2f 00 00    	pushq  0x2f6a(%rip)        # 3f90 <exit@plt+0x2e80>
    1026:	f2 ff 25 6b 2f 00 00 	bnd jmpq *0x2f6b(%rip)        # 3f98 <exit@plt+0x2e88>
    102d:	0f 1f 00             	nopl   (%rax)
    1030:	f3 0f 1e fa          	endbr64 
    1034:	68 00 00 00 00       	pushq  $0x0
    1039:	f2 e9 e1 ff ff ff    	bnd jmpq 1020 <__cxa_finalize@plt-0x80>
    103f:	90                   	nop
    1040:	f3 0f 1e fa          	endbr64 
    1044:	68 01 00 00 00       	pushq  $0x1
    1049:	f2 e9 d1 ff ff ff    	bnd jmpq 1020 <__cxa_finalize@plt-0x80>
    104f:	90                   	nop
    1050:	f3 0f 1e fa          	endbr64 
    1054:	68 02 00 00 00       	pushq  $0x2
    1059:	f2 e9 c1 ff ff ff    	bnd jmpq 1020 <__cxa_finalize@plt-0x80>
    105f:	90                   	nop
    1060:	f3 0f 1e fa          	endbr64 
    1064:	68 03 00 00 00       	pushq  $0x3
    1069:	f2 e9 b1 ff ff ff    	bnd jmpq 1020 <__cxa_finalize@plt-0x80>
    106f:	90                   	nop
    1070:	f3 0f 1e fa          	endbr64 
    1074:	68 04 00 00 00       	pushq  $0x4
    1079:	f2 e9 a1 ff ff ff    	bnd jmpq 1020 <__cxa_finalize@plt-0x80>
    107f:	90                   	nop
    1080:	f3 0f 1e fa          	endbr64 
    1084:	68 05 00 00 00       	pushq  $0x5
    1089:	f2 e9 91 ff ff ff    	bnd jmpq 1020 <__cxa_finalize@plt-0x80>
    108f:	90                   	nop
    1090:	f3 0f 1e fa          	endbr64 
    1094:	68 06 00 00 00       	pushq  $0x6
    1099:	f2 e9 81 ff ff ff    	bnd jmpq 1020 <__cxa_finalize@plt-0x80>
    109f:	90                   	nop

Disassembly of section .plt.got:

00000000000010a0 <__cxa_finalize@plt>:
    10a0:	f3 0f 1e fa          	endbr64 
    10a4:	f2 ff 25 4d 2f 00 00 	bnd jmpq *0x2f4d(%rip)        # 3ff8 <exit@plt+0x2ee8>
    10ab:	0f 1f 44 00 00       	nopl   0x0(%rax,%rax,1)

Disassembly of section .plt.sec:

00000000000010b0 <puts@plt>:
    10b0:	f3 0f 1e fa          	endbr64 
    10b4:	f2 ff 25 e5 2e 00 00 	bnd jmpq *0x2ee5(%rip)        # 3fa0 <exit@plt+0x2e90>
    10bb:	0f 1f 44 00 00       	nopl   0x0(%rax,%rax,1)

00000000000010c0 <strlen@plt>:
    10c0:	f3 0f 1e fa          	endbr64 
    10c4:	f2 ff 25 dd 2e 00 00 	bnd jmpq *0x2edd(%rip)        # 3fa8 <exit@plt+0x2e98>
    10cb:	0f 1f 44 00 00       	nopl   0x0(%rax,%rax,1)

00000000000010d0 <__stack_chk_fail@plt>:
    10d0:	f3 0f 1e fa          	endbr64 
    10d4:	f2 ff 25 d5 2e 00 00 	bnd jmpq *0x2ed5(%rip)        # 3fb0 <exit@plt+0x2ea0>
    10db:	0f 1f 44 00 00       	nopl   0x0(%rax,%rax,1)

00000000000010e0 <printf@plt>:
    10e0:	f3 0f 1e fa          	endbr64 
    10e4:	f2 ff 25 cd 2e 00 00 	bnd jmpq *0x2ecd(%rip)        # 3fb8 <exit@plt+0x2ea8>
    10eb:	0f 1f 44 00 00       	nopl   0x0(%rax,%rax,1)

00000000000010f0 <strcmp@plt>:
    10f0:	f3 0f 1e fa          	endbr64 
    10f4:	f2 ff 25 c5 2e 00 00 	bnd jmpq *0x2ec5(%rip)        # 3fc0 <exit@plt+0x2eb0>
    10fb:	0f 1f 44 00 00       	nopl   0x0(%rax,%rax,1)

0000000000001100 <__isoc99_scanf@plt>:
    1100:	f3 0f 1e fa          	endbr64 
    1104:	f2 ff 25 bd 2e 00 00 	bnd jmpq *0x2ebd(%rip)        # 3fc8 <exit@plt+0x2eb8>
    110b:	0f 1f 44 00 00       	nopl   0x0(%rax,%rax,1)

0000000000001110 <exit@plt>:
    1110:	f3 0f 1e fa          	endbr64 
    1114:	f2 ff 25 b5 2e 00 00 	bnd jmpq *0x2eb5(%rip)        # 3fd0 <exit@plt+0x2ec0>
    111b:	0f 1f 44 00 00       	nopl   0x0(%rax,%rax,1)

Disassembly of section .text:

0000000000001120 <.text>:
    1120:	f3 0f 1e fa          	endbr64 
    1124:	31 ed                	xor    %ebp,%ebp
    1126:	49 89 d1             	mov    %rdx,%r9
    1129:	5e                   	pop    %rsi
    112a:	48 89 e2             	mov    %rsp,%rdx
    112d:	48 83 e4 f0          	and    $0xfffffffffffffff0,%rsp
    1131:	50                   	push   %rax
    1132:	54                   	push   %rsp
    1133:	4c 8d 05 56 04 00 00 	lea    0x456(%rip),%r8        # 1590 <exit@plt+0x480>
    113a:	48 8d 0d df 03 00 00 	lea    0x3df(%rip),%rcx        # 1520 <exit@plt+0x410>
    1141:	48 8d 3d df 02 00 00 	lea    0x2df(%rip),%rdi        # 1427 <exit@plt+0x317>
    1148:	ff 15 92 2e 00 00    	callq  *0x2e92(%rip)        # 3fe0 <exit@plt+0x2ed0>
    114e:	f4                   	hlt    
    114f:	90                   	nop
    1150:	48 8d 3d 61 2f 00 00 	lea    0x2f61(%rip),%rdi        # 40b8 <exit@plt+0x2fa8>
    1157:	48 8d 05 5a 2f 00 00 	lea    0x2f5a(%rip),%rax        # 40b8 <exit@plt+0x2fa8>
    115e:	48 39 f8             	cmp    %rdi,%rax
    1161:	74 15                	je     1178 <exit@plt+0x68>
    1163:	48 8b 05 6e 2e 00 00 	mov    0x2e6e(%rip),%rax        # 3fd8 <exit@plt+0x2ec8>
    116a:	48 85 c0             	test   %rax,%rax
    116d:	74 09                	je     1178 <exit@plt+0x68>
    116f:	ff e0                	jmpq   *%rax
    1171:	0f 1f 80 00 00 00 00 	nopl   0x0(%rax)
    1178:	c3                   	retq   
    1179:	0f 1f 80 00 00 00 00 	nopl   0x0(%rax)
    1180:	48 8d 3d 31 2f 00 00 	lea    0x2f31(%rip),%rdi        # 40b8 <exit@plt+0x2fa8>
    1187:	48 8d 35 2a 2f 00 00 	lea    0x2f2a(%rip),%rsi        # 40b8 <exit@plt+0x2fa8>
    118e:	48 29 fe             	sub    %rdi,%rsi
    1191:	48 89 f0             	mov    %rsi,%rax
    1194:	48 c1 ee 3f          	shr    $0x3f,%rsi
    1198:	48 c1 f8 03          	sar    $0x3,%rax
    119c:	48 01 c6             	add    %rax,%rsi
    119f:	48 d1 fe             	sar    %rsi
    11a2:	74 14                	je     11b8 <exit@plt+0xa8>
    11a4:	48 8b 05 45 2e 00 00 	mov    0x2e45(%rip),%rax        # 3ff0 <exit@plt+0x2ee0>
    11ab:	48 85 c0             	test   %rax,%rax
    11ae:	74 08                	je     11b8 <exit@plt+0xa8>
    11b0:	ff e0                	jmpq   *%rax
    11b2:	66 0f 1f 44 00 00    	nopw   0x0(%rax,%rax,1)
    11b8:	c3                   	retq   
    11b9:	0f 1f 80 00 00 00 00 	nopl   0x0(%rax)
    11c0:	f3 0f 1e fa          	endbr64 
    11c4:	80 3d ed 2e 00 00 00 	cmpb   $0x0,0x2eed(%rip)        # 40b8 <exit@plt+0x2fa8>
    11cb:	75 2b                	jne    11f8 <exit@plt+0xe8>
    11cd:	55                   	push   %rbp
    11ce:	48 83 3d 22 2e 00 00 	cmpq   $0x0,0x2e22(%rip)        # 3ff8 <exit@plt+0x2ee8>
    11d5:	00 
    11d6:	48 89 e5             	mov    %rsp,%rbp
    11d9:	74 0c                	je     11e7 <exit@plt+0xd7>
    11db:	48 8b 3d 26 2e 00 00 	mov    0x2e26(%rip),%rdi        # 4008 <exit@plt+0x2ef8>
    11e2:	e8 b9 fe ff ff       	callq  10a0 <__cxa_finalize@plt>
    11e7:	e8 64 ff ff ff       	callq  1150 <exit@plt+0x40>
    11ec:	c6 05 c5 2e 00 00 01 	movb   $0x1,0x2ec5(%rip)        # 40b8 <exit@plt+0x2fa8>
    11f3:	5d                   	pop    %rbp
    11f4:	c3                   	retq   
    11f5:	0f 1f 00             	nopl   (%rax)
    11f8:	c3                   	retq   
    11f9:	0f 1f 80 00 00 00 00 	nopl   0x0(%rax)
    1200:	f3 0f 1e fa          	endbr64 
    1204:	e9 77 ff ff ff       	jmpq   1180 <exit@plt+0x70>
    1209:	f3 0f 1e fa          	endbr64 
    120d:	55                   	push   %rbp
    120e:	48 89 e5             	mov    %rsp,%rbp
    1211:	53                   	push   %rbx
    1212:	48 83 ec 28          	sub    $0x28,%rsp
    1216:	48 89 7d d8          	mov    %rdi,-0x28(%rbp)
    121a:	48 89 75 d0          	mov    %rsi,-0x30(%rbp)
    121e:	c7 45 ec 00 00 00 00 	movl   $0x0,-0x14(%rbp)
    1225:	eb 69                	jmp    1290 <exit@plt+0x180>
    1227:	8b 45 ec             	mov    -0x14(%rbp),%eax
    122a:	48 63 d0             	movslq %eax,%rdx
    122d:	48 8b 45 d8          	mov    -0x28(%rbp),%rax
    1231:	48 01 d0             	add    %rdx,%rax
    1234:	0f b6 00             	movzbl (%rax),%eax
    1237:	0f be f0             	movsbl %al,%esi
    123a:	8b 55 ec             	mov    -0x14(%rbp),%edx
    123d:	48 63 c2             	movslq %edx,%rax
    1240:	48 69 c0 93 24 49 92 	imul   $0xffffffff92492493,%rax,%rax
    1247:	48 c1 e8 20          	shr    $0x20,%rax
    124b:	01 d0                	add    %edx,%eax
    124d:	c1 f8 02             	sar    $0x2,%eax
    1250:	89 c1                	mov    %eax,%ecx
    1252:	89 d0                	mov    %edx,%eax
    1254:	c1 f8 1f             	sar    $0x1f,%eax
    1257:	29 c1                	sub    %eax,%ecx
    1259:	89 c8                	mov    %ecx,%eax
    125b:	89 c1                	mov    %eax,%ecx
    125d:	c1 e1 03             	shl    $0x3,%ecx
    1260:	29 c1                	sub    %eax,%ecx
    1262:	89 d0                	mov    %edx,%eax
    1264:	29 c8                	sub    %ecx,%eax
    1266:	89 c1                	mov    %eax,%ecx
    1268:	d3 e6                	shl    %cl,%esi
    126a:	89 f1                	mov    %esi,%ecx
    126c:	8b 45 ec             	mov    -0x14(%rbp),%eax
    126f:	0f af c0             	imul   %eax,%eax
    1272:	89 c2                	mov    %eax,%edx
    1274:	8b 45 ec             	mov    -0x14(%rbp),%eax
    1277:	48 98                	cltq   
    1279:	48 8d 34 85 00 00 00 	lea    0x0(,%rax,4),%rsi
    1280:	00 
    1281:	48 8b 45 d0          	mov    -0x30(%rbp),%rax
    1285:	48 01 f0             	add    %rsi,%rax
    1288:	01 ca                	add    %ecx,%edx
    128a:	89 10                	mov    %edx,(%rax)
    128c:	83 45 ec 01          	addl   $0x1,-0x14(%rbp)
    1290:	8b 45 ec             	mov    -0x14(%rbp),%eax
    1293:	48 63 d8             	movslq %eax,%rbx
    1296:	48 8b 45 d8          	mov    -0x28(%rbp),%rax
    129a:	48 89 c7             	mov    %rax,%rdi
    129d:	e8 1e fe ff ff       	callq  10c0 <strlen@plt>
    12a2:	48 39 c3             	cmp    %rax,%rbx
    12a5:	72 80                	jb     1227 <exit@plt+0x117>
    12a7:	48 8b 45 d0          	mov    -0x30(%rbp),%rax
    12ab:	48 83 c4 28          	add    $0x28,%rsp
    12af:	5b                   	pop    %rbx
    12b0:	5d                   	pop    %rbp
    12b1:	c3                   	retq   
    12b2:	f3 0f 1e fa          	endbr64 
    12b6:	55                   	push   %rbp
    12b7:	48 89 e5             	mov    %rsp,%rbp
    12ba:	41 57                	push   %r15
    12bc:	41 56                	push   %r14
    12be:	41 54                	push   %r12
    12c0:	53                   	push   %rbx
    12c1:	48 83 ec 40          	sub    $0x40,%rsp
    12c5:	48 89 7d b8          	mov    %rdi,-0x48(%rbp)
    12c9:	64 48 8b 04 25 28 00 	mov    %fs:0x28,%rax
    12d0:	00 00 
    12d2:	48 89 45 d8          	mov    %rax,-0x28(%rbp)
    12d6:	31 c0                	xor    %eax,%eax
    12d8:	48 89 e0             	mov    %rsp,%rax
    12db:	49 89 c4             	mov    %rax,%r12
    12de:	48 8b 45 b8          	mov    -0x48(%rbp),%rax
    12e2:	48 89 c7             	mov    %rax,%rdi
    12e5:	e8 d6 fd ff ff       	callq  10c0 <strlen@plt>
    12ea:	48 89 c2             	mov    %rax,%rdx
    12ed:	48 83 ea 01          	sub    $0x1,%rdx
    12f1:	48 89 55 c8          	mov    %rdx,-0x38(%rbp)
    12f5:	48 89 45 a0          	mov    %rax,-0x60(%rbp)
    12f9:	48 c7 45 a8 00 00 00 	movq   $0x0,-0x58(%rbp)
    1300:	00 
    1301:	49 89 c6             	mov    %rax,%r14
    1304:	41 bf 00 00 00 00    	mov    $0x0,%r15d
    130a:	48 8d 14 85 00 00 00 	lea    0x0(,%rax,4),%rdx
    1311:	00 
    1312:	b8 10 00 00 00       	mov    $0x10,%eax
    1317:	48 83 e8 01          	sub    $0x1,%rax
    131b:	48 01 d0             	add    %rdx,%rax
    131e:	bb 10 00 00 00       	mov    $0x10,%ebx
    1323:	ba 00 00 00 00       	mov    $0x0,%edx
    1328:	48 f7 f3             	div    %rbx
    132b:	48 6b c0 10          	imul   $0x10,%rax,%rax
    132f:	48 89 c2             	mov    %rax,%rdx
    1332:	48 81 e2 00 f0 ff ff 	and    $0xfffffffffffff000,%rdx
    1339:	48 89 e6             	mov    %rsp,%rsi
    133c:	48 29 d6             	sub    %rdx,%rsi
    133f:	48 89 f2             	mov    %rsi,%rdx
    1342:	48 39 d4             	cmp    %rdx,%rsp
    1345:	74 12                	je     1359 <exit@plt+0x249>
    1347:	48 81 ec 00 10 00 00 	sub    $0x1000,%rsp
    134e:	48 83 8c 24 f8 0f 00 	orq    $0x0,0xff8(%rsp)
    1355:	00 00 
    1357:	eb e9                	jmp    1342 <exit@plt+0x232>
    1359:	48 89 c2             	mov    %rax,%rdx
    135c:	81 e2 ff 0f 00 00    	and    $0xfff,%edx
    1362:	48 29 d4             	sub    %rdx,%rsp
    1365:	48 89 c2             	mov    %rax,%rdx
    1368:	81 e2 ff 0f 00 00    	and    $0xfff,%edx
    136e:	48 85 d2             	test   %rdx,%rdx
    1371:	74 10                	je     1383 <exit@plt+0x273>
    1373:	25 ff 0f 00 00       	and    $0xfff,%eax
    1378:	48 83 e8 08          	sub    $0x8,%rax
    137c:	48 01 e0             	add    %rsp,%rax
    137f:	48 83 08 00          	orq    $0x0,(%rax)
    1383:	48 89 e0             	mov    %rsp,%rax
    1386:	48 83 c0 03          	add    $0x3,%rax
    138a:	48 c1 e8 02          	shr    $0x2,%rax
    138e:	48 c1 e0 02          	shl    $0x2,%rax
    1392:	48 89 45 d0          	mov    %rax,-0x30(%rbp)
    1396:	c7 45 c4 00 00 00 00 	movl   $0x0,-0x3c(%rbp)
    139d:	48 8b 55 d0          	mov    -0x30(%rbp),%rdx
    13a1:	48 8b 45 b8          	mov    -0x48(%rbp),%rax
    13a5:	48 89 d6             	mov    %rdx,%rsi
    13a8:	48 89 c7             	mov    %rax,%rdi
    13ab:	e8 59 fe ff ff       	callq  1209 <exit@plt+0xf9>
    13b0:	c7 45 c0 00 00 00 00 	movl   $0x0,-0x40(%rbp)
    13b7:	eb 30                	jmp    13e9 <exit@plt+0x2d9>
    13b9:	8b 45 c0             	mov    -0x40(%rbp),%eax
    13bc:	48 98                	cltq   
    13be:	48 8d 14 85 00 00 00 	lea    0x0(,%rax,4),%rdx
    13c5:	00 
    13c6:	48 8d 05 53 2c 00 00 	lea    0x2c53(%rip),%rax        # 4020 <exit@plt+0x2f10>
    13cd:	8b 0c 02             	mov    (%rdx,%rax,1),%ecx
    13d0:	48 8b 45 d0          	mov    -0x30(%rbp),%rax
    13d4:	8b 55 c0             	mov    -0x40(%rbp),%edx
    13d7:	48 63 d2             	movslq %edx,%rdx
    13da:	8b 04 90             	mov    (%rax,%rdx,4),%eax
    13dd:	39 c1                	cmp    %eax,%ecx
    13df:	75 04                	jne    13e5 <exit@plt+0x2d5>
    13e1:	83 45 c4 01          	addl   $0x1,-0x3c(%rbp)
    13e5:	83 45 c0 01          	addl   $0x1,-0x40(%rbp)
    13e9:	8b 45 c0             	mov    -0x40(%rbp),%eax
    13ec:	48 63 d8             	movslq %eax,%rbx
    13ef:	48 8b 45 b8          	mov    -0x48(%rbp),%rax
    13f3:	48 89 c7             	mov    %rax,%rdi
    13f6:	e8 c5 fc ff ff       	callq  10c0 <strlen@plt>
    13fb:	48 39 c3             	cmp    %rax,%rbx
    13fe:	72 b9                	jb     13b9 <exit@plt+0x2a9>
    1400:	8b 45 c4             	mov    -0x3c(%rbp),%eax
    1403:	4c 89 e4             	mov    %r12,%rsp
    1406:	48 8b 4d d8          	mov    -0x28(%rbp),%rcx
    140a:	64 48 33 0c 25 28 00 	xor    %fs:0x28,%rcx
    1411:	00 00 
    1413:	74 05                	je     141a <exit@plt+0x30a>
    1415:	e8 b6 fc ff ff       	callq  10d0 <__stack_chk_fail@plt>
    141a:	48 8d 65 e0          	lea    -0x20(%rbp),%rsp
    141e:	5b                   	pop    %rbx
    141f:	41 5c                	pop    %r12
    1421:	41 5e                	pop    %r14
    1423:	41 5f                	pop    %r15
    1425:	5d                   	pop    %rbp
    1426:	c3                   	retq   
    1427:	f3 0f 1e fa          	endbr64 
    142b:	55                   	push   %rbp
    142c:	48 89 e5             	mov    %rsp,%rbp
    142f:	48 83 ec 40          	sub    $0x40,%rsp
    1433:	64 48 8b 04 25 28 00 	mov    %fs:0x28,%rax
    143a:	00 00 
    143c:	48 89 45 f8          	mov    %rax,-0x8(%rbp)
    1440:	31 c0                	xor    %eax,%eax
    1442:	48 8d 3d bf 0b 00 00 	lea    0xbbf(%rip),%rdi        # 2008 <exit@plt+0xef8>
    1449:	b8 00 00 00 00       	mov    $0x0,%eax
    144e:	e8 8d fc ff ff       	callq  10e0 <printf@plt>
    1453:	48 8d 45 c0          	lea    -0x40(%rbp),%rax
    1457:	48 89 c6             	mov    %rax,%rsi
    145a:	48 8d 3d e4 0b 00 00 	lea    0xbe4(%rip),%rdi        # 2045 <exit@plt+0xf35>
    1461:	b8 00 00 00 00       	mov    $0x0,%eax
    1466:	e8 95 fc ff ff       	callq  1100 <__isoc99_scanf@plt>
    146b:	48 8d 3d d6 0b 00 00 	lea    0xbd6(%rip),%rdi        # 2048 <exit@plt+0xf38>
    1472:	b8 00 00 00 00       	mov    $0x0,%eax
    1477:	e8 64 fc ff ff       	callq  10e0 <printf@plt>
    147c:	48 8d 45 d0          	lea    -0x30(%rbp),%rax
    1480:	48 89 c6             	mov    %rax,%rsi
    1483:	48 8d 3d bb 0b 00 00 	lea    0xbbb(%rip),%rdi        # 2045 <exit@plt+0xf35>
    148a:	b8 00 00 00 00       	mov    $0x0,%eax
    148f:	e8 6c fc ff ff       	callq  1100 <__isoc99_scanf@plt>
    1494:	48 8d 45 c0          	lea    -0x40(%rbp),%rax
    1498:	48 8d 35 c6 0b 00 00 	lea    0xbc6(%rip),%rsi        # 2065 <exit@plt+0xf55>
    149f:	48 89 c7             	mov    %rax,%rdi
    14a2:	e8 49 fc ff ff       	callq  10f0 <strcmp@plt>
    14a7:	85 c0                	test   %eax,%eax
    14a9:	75 30                	jne    14db <exit@plt+0x3cb>
    14ab:	48 8d 3d bc 0b 00 00 	lea    0xbbc(%rip),%rdi        # 206e <exit@plt+0xf5e>
    14b2:	e8 f9 fb ff ff       	callq  10b0 <puts@plt>
    14b7:	48 8d 45 d0          	lea    -0x30(%rbp),%rax
    14bb:	48 89 c7             	mov    %rax,%rdi
    14be:	e8 ef fd ff ff       	callq  12b2 <exit@plt+0x1a2>
    14c3:	83 f8 26             	cmp    $0x26,%eax
    14c6:	75 35                	jne    14fd <exit@plt+0x3ed>
    14c8:	48 8d 3d b4 0b 00 00 	lea    0xbb4(%rip),%rdi        # 2083 <exit@plt+0xf73>
    14cf:	b8 00 00 00 00       	mov    $0x0,%eax
    14d4:	e8 07 fc ff ff       	callq  10e0 <printf@plt>
    14d9:	eb 22                	jmp    14fd <exit@plt+0x3ed>
    14db:	48 8d 45 c0          	lea    -0x40(%rbp),%rax
    14df:	48 89 c6             	mov    %rax,%rsi
    14e2:	48 8d 3d af 0b 00 00 	lea    0xbaf(%rip),%rdi        # 2098 <exit@plt+0xf88>
    14e9:	b8 00 00 00 00       	mov    $0x0,%eax
    14ee:	e8 ed fb ff ff       	callq  10e0 <printf@plt>
    14f3:	bf 00 00 00 00       	mov    $0x0,%edi
    14f8:	e8 13 fc ff ff       	callq  1110 <exit@plt>
    14fd:	b8 00 00 00 00       	mov    $0x0,%eax
    1502:	48 8b 55 f8          	mov    -0x8(%rbp),%rdx
    1506:	64 48 33 14 25 28 00 	xor    %fs:0x28,%rdx
    150d:	00 00 
    150f:	74 05                	je     1516 <exit@plt+0x406>
    1511:	e8 ba fb ff ff       	callq  10d0 <__stack_chk_fail@plt>
    1516:	c9                   	leaveq 
    1517:	c3                   	retq   
    1518:	0f 1f 84 00 00 00 00 	nopl   0x0(%rax,%rax,1)
    151f:	00 
    1520:	f3 0f 1e fa          	endbr64 
    1524:	41 57                	push   %r15
    1526:	4c 8d 3d 5b 28 00 00 	lea    0x285b(%rip),%r15        # 3d88 <exit@plt+0x2c78>
    152d:	41 56                	push   %r14
    152f:	49 89 d6             	mov    %rdx,%r14
    1532:	41 55                	push   %r13
    1534:	49 89 f5             	mov    %rsi,%r13
    1537:	41 54                	push   %r12
    1539:	41 89 fc             	mov    %edi,%r12d
    153c:	55                   	push   %rbp
    153d:	48 8d 2d 4c 28 00 00 	lea    0x284c(%rip),%rbp        # 3d90 <exit@plt+0x2c80>
    1544:	53                   	push   %rbx
    1545:	4c 29 fd             	sub    %r15,%rbp
    1548:	48 83 ec 08          	sub    $0x8,%rsp
    154c:	e8 af fa ff ff       	callq  1000 <__cxa_finalize@plt-0xa0>
    1551:	48 c1 fd 03          	sar    $0x3,%rbp
    1555:	74 1f                	je     1576 <exit@plt+0x466>
    1557:	31 db                	xor    %ebx,%ebx
    1559:	0f 1f 80 00 00 00 00 	nopl   0x0(%rax)
    1560:	4c 89 f2             	mov    %r14,%rdx
    1563:	4c 89 ee             	mov    %r13,%rsi
    1566:	44 89 e7             	mov    %r12d,%edi
    1569:	41 ff 14 df          	callq  *(%r15,%rbx,8)
    156d:	48 83 c3 01          	add    $0x1,%rbx
    1571:	48 39 dd             	cmp    %rbx,%rbp
    1574:	75 ea                	jne    1560 <exit@plt+0x450>
    1576:	48 83 c4 08          	add    $0x8,%rsp
    157a:	5b                   	pop    %rbx
    157b:	5d                   	pop    %rbp
    157c:	41 5c                	pop    %r12
    157e:	41 5d                	pop    %r13
    1580:	41 5e                	pop    %r14
    1582:	41 5f                	pop    %r15
    1584:	c3                   	retq   
    1585:	66 66 2e 0f 1f 84 00 	data16 nopw %cs:0x0(%rax,%rax,1)
    158c:	00 00 00 00 
    1590:	f3 0f 1e fa          	endbr64 
    1594:	c3                   	retq   

Disassembly of section .fini:

0000000000001598 <.fini>:
    1598:	f3 0f 1e fa          	endbr64 
    159c:	48 83 ec 08          	sub    $0x8,%rsp
    15a0:	48 83 c4 08          	add    $0x8,%rsp
    15a4:	c3                   	retq   
