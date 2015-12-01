/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zakigantengtekom;
import java.io.PrintStream;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author Zaki
 */
public class ZakiGantengTekom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Stack<Character> stackChar = new Stack<Character>();
        stackChar.push((Character)'#');
        stackChar.push((Character)'A');
        Scanner str = new Scanner(System.in);
        String s = str.next();
        //System.out.println(s);
        //String s="zakiganteng+123E-213*24,5/()-456";
        
        int i=0;
        int g=0;
        int c = 0;
        int d = 0;
        char[] charArray = s.toCharArray();
        for(i=0;i<charArray.length;i++){
            if( charArray[i]=='1'||
                charArray[i]=='2'||
                charArray[i]=='3'){
                charArray[i]='1';
            }else if(charArray[i]=='4'){
                charArray[i]='2';
            }else if(charArray[i]=='5'){
                charArray[i]='3';
            }else{
                charArray[i]='4';
            }
        }
        int n =0;
        char symbol2; 
        while(stackChar.peek()!='#'){
            n++;
            char symbol=charArray[charArray.length-1];
            if(n==2*(charArray.length)+1){break;}
            if(g!=charArray.length){
            symbol =charArray[g];
            }
            if(g+1>=charArray.length){
                symbol2 = symbol;
            }else{symbol2 =charArray[g+1]; }
            if(g==charArray.length){
                break;
            }
            //System.out.println(symbol2);
            //System.out.println(stackChar);
            switch (stackChar.peek()) {
                case 'A':if(symbol2=='4' &&  symbol=='1'){
                            stackChar.pop();
                            stackChar.push('A');
                            stackChar.push('4');
                            stackChar.push('1');
                            d+=1;
                             }
                          else if (symbol=='2' && symbol2=='1'){
                              stackChar.pop();
                              stackChar.push('3');
                              stackChar.push('A');
                              stackChar.push('2');
                              c+=1;
                          }
                          else if (symbol=='1' && symbol2!='2'){
                              stackChar.pop();
                              stackChar.push('1');
                              d+=1;
                                
                          }
                         break;
                case '1': if(symbol != '1'){break;}
                          else{
                                stackChar.pop();
                                g+=1;
                              }
                          break;
                case '2': if(symbol != '2'){break;}
                          else{
                                stackChar.pop();
                                g+=1;
                              }
                          break;
                case '3': if(symbol != '3'){break;}
                          else{
                                stackChar.pop();
                                g+=1;
                                c-=1;
                              }
                          break;
                case '4': if(symbol != '4'){break;}
                          else{
                                stackChar.pop();
                                g+=1;
                              }  
                          break;
            }
            }
        //System.out.println(d%2);
        if(stackChar.peek()=='#' && c==0 && d%2==0){
            System.out.println("Valid");
        }else{
            System.out.println("TIDAK VALID");
       
        }
        }
        
    }


