package com.company;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
public @Data class Spartan {

    String name;
    int age;

    public static void main(String[] args) {
        Spartan a = new Spartan("Yes",10);
        a.setAge(20);
        System.out.println(a);

    }
}
