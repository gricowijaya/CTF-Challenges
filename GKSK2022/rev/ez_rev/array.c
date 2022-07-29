__int64 __fastcall main(__int64 a1, char **a2, char **a3)
{
  int i; // [rsp+8h] [rbp-118h]
  int j; // [rsp+Ch] [rbp-114h]
  int v6[52]; // [rsp+10h] [rbp-110h]
  char v7[56]; // [rsp+E0h] [rbp-40h] BYREF
  unsigned __int64 v8; // [rsp+118h] [rbp-8h]

  v8 = __readfsqword(0x28u);
  v6[0] = 87;
  v6[1] = 91;
  v6[2] = 67;
  v6[3] = 91;
  v6[4] = 34;
  v6[5] = 34;
  v6[6] = 107;
  v6[7] = 117;
  v6[8] = 106;
  v6[9] = 79;
  v6[10] = 98;
  v6[11] = 35;
  v6[12] = 102;
  v6[13] = 79;
  v6[14] = 114;
  v6[15] = 101;
  v6[16] = 100;
  v6[17] = 79;
  v6[18] = 99;
  v6[19] = 100;
  v6[20] = 98;
  v6[21] = 33;
  v6[22] = 96;
  v6[23] = 96;
  v6[24] = 35;
  v6[25] = 116;
  v6[26] = 79;
  v6[27] = 0x72;
  v6[28] = 33;
  v6[29] = 126;
  v6[30] = 79;
  v6[31] = 125;
  v6[32] = 113;
  v6[33] = 123;
  v6[34] = 35;
  v6[35] = 79;
  v6[36] = 33;
  v6[37] = 100;
  v6[38] = 79;
  v6[39] = 124;
  v6[40] = 127;
  v6[41] = 32;
  v6[42] = 123;
  v6[43] = 99;
  v6[44] = 79;
  v6[45] = 120;
  v6[46] = 36;
  v6[47] = 98;
  v6[48] = 116;
  v6[49] = 35;
  v6[50] = 98;
  v6[51] = 109;
  ((void (__fastcall *)(__int64, char **, char **))((char *)&sub_11A8 + 1))(a1, a2, a3);
  printf("\n\nTebak Flag-nya Kak : ");
  __isoc99_scanf("%s", v7);
  for ( i = 0; v7[i]; ++i )
    ;
  for ( j = 0; j < i; ++j )
  {
    if ( (char)(v7[j] ^ 0x10) != v6[j] )
    {
      puts("Salah Kak");
      break;
    }
    puts("Selamat Kak");
  }
  printf("bye bye!");
  return 0LL;
}
