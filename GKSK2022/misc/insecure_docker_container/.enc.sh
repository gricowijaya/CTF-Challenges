#!/bin/bash

l="gksk2022{ini_"
r="bukan_flag}"
l_strlen=${#l}
r_strlen=${#r}
for (( i=$l_strlen-1; i>=0; i-- ));
do
    revstr=$revstr${l:$i:1}
done
for (( i=$r_strlen-1; i>=0; i-- ));
do
    reved=$reved${r:$i:1}
done

echo $revstr$reved;
# zip --password $revstr$reved flag1.zip 
