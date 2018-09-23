
TestCrime.java:

import java.io.BufferedReader;

import java.io.DataInputStream;

import java.io.FileInputStream;

import java.io.InputStreamReader;

import java.util.ArrayList;

import java.util.Scanner;

public class TestCrime{

   public static void Pop_Growth(ArrayList StoreList) {

       System.out.println("The percentages in population growth for each consecutive year from 1994 – 2013");

        for (int i = 0; i < StoreList.size(); i++) {

            US_Crime Fault = (US_Crime) StoreList.get(i);

            US_Crime Usc1 = null;

           if (Fault.YYYY < 2013) {//year filtered

                Usc1 = (US_Crime) StoreList.get(i + 1);

                System.out.println(" Duration : "

                                + Fault.YYYY

                                + "-"

                                + Usc1.YYYY

                                + " --> "

        + (((Usc1.Population - Fault.Population) / Fault.Population) * 100)

                                + "%");

            }

        }

    }

   public static void Motor_theft(ArrayList Storelist)

      {

System.out.println("The total percentage change in Motor Vehicle Theft between 1998 and 2012");

           for (int i = 0; i < Storelist.size(); i++)

            {

                  US_Crime Fault = (US_Crime) Storelist.get(i);

                  US_Crime Usc1 = null;

if (Fault.YYYY > 1998 && Fault.YYYY < 2013) {//year filtering

                  Usc1 = (US_Crime) Storelist.get(i + 1);

                System.out.println(" Duration : "

                                + Fault.YYYY

                                + "-"

                                + Usc1.YYYY

                                + " --> "

+ (((Usc1.Motor_vehicle_theft - Fault.Motor_vehicle_theft) / Fault.Motor_vehicle_theft) * 100)

                                + "%");

            }

        }

    }

   public static void Highest_Murder_Rate(ArrayList StoreList)

      {

            double max_Murderrate = Double.MIN_VALUE;

            int YYYY = 0;

            for (int i = 0; i < StoreList.size(); i++)

            {

                  US_Crime fault = (US_Crime) StoreList.get(i);

if (max_Murderrate < fault.Murder_and_nonnegligent_manslaughter_rate)

{

max_Murderrate = fault.Murder_and_nonnegligent_manslaughter_rate;

                     YYYY = (int) fault.YYYY;

            }

        }

        System.out.println("Murder rate the highest : ---> " + YYYY);

    }

   public static void Lowest_Murder_Rate(ArrayList StoreList)

      {

            double min_Murderrate = Double.MAX_VALUE;

              int YYYY = 0;

            for (int i = 0; i < StoreList.size(); i++)

            {

                  US_Crime fault = (US_Crime) StoreList.get(i);

if (min_Murderrate > fault.Murder_and_nonnegligent_manslaughter_rate) {

min_Murderrate = fault.Murder_and_nonnegligent_manslaughter_rate;

                  YYYY = (int) fault.YYYY;

            }

        }

System.out.println("The murder rate was highest in the year : ---> " + YYYY);

    }

   public static void Highest_Robbery_Rate(ArrayList StoreList)

      {

            double max_Robberyrrate = Double.MIN_VALUE;

              int yyyy = 0;

            for (int i = 0; i < StoreList.size(); i++)

            {

                  US_Crime fault = (US_Crime) StoreList.get(i);

                if (max_Robberyrrate < fault.Robbery_rate) {

                      max_Robberyrrate = fault.Robbery_rate;

               yyyy = (int) fault.YYYY;

            }

       }

       System.out.println("Robbery_rate the highest : ---> " + yyyy);

    }

       public static void Lowest_Robbery_Rate(ArrayList StoreList)

      {

            double min_Robberyrrate = Double.MAX_VALUE;

              int yyyy = 0;

            for (int i = 0; i < StoreList.size(); i++)

            {

                  US_Crime Fault = (US_Crime) StoreList.get(i);

                if (min_Robberyrrate > Fault.Robbery_rate) {

                      min_Robberyrrate = Fault.Robbery_rate;

                 yyyy = (int) Fault.YYYY;

            }

        }

        System.out.println("Robbery_rate the LOWEST : ---> " + yyyy);

    }

   public static US_Crime storeToCrimeObjin(String line)

      {

            String[] data = line.split(",");

              US_Crime fault = new US_Crime(data);

            return fault;

      }

   @SuppressWarnings({ "rawtypes", "unchecked" })

  

    public static void main(String[] args)

      {

            long TimeStarted = System.currentTimeMillis();

System.out.println("********** Welcome to the US Crime Statistical Application **************************");

              String InputFile = "Crime.csv";// give your in file

            Try

            {

                 ArrayList small = new ArrayList<US_Crime>();

                  FileInputStream Filestr = new FileInputStream(InputFile);

                // Get the object of DataInputStream

                  DataInputStream In = new DataInputStream(Filestr);

BufferedReader Br = new BufferedReader(new InputStreamReader(In));

                  String StrLine;

                // Read File Line By Line

                  StrLine = Br.readLine();// skip first line

                while ((StrLine = Br.readLine()) != null) {// lines

                      small.add(storeToCrimeObjin(StrLine));

                }

            // Close the input stream

            In.close();

             Scanner Sc = new Scanner(System.in);

            char Ch = '\0';

              while (Ch != 'Q')

            {

                  PrintMenu.printMenu();

                Ch = Sc.next().charAt(0);

                switch (Ch) {

                case '1':

                    Pop_Growth(small);

                    break;

                case '2':

                    Highest_Murder_Rate(small);

                    break;

                case '3':

                    Lowest_Murder_Rate(small);

                    break;

                case '4':

                    Highest_Robbery_Rate(small);

                    break;

                case '5':

                    Lowest_Robbery_Rate(small);

                    break;

                case '6':

                    Motor_theft(small);

                    break;

                case '7':

                    //Please defined clear explanation what to do

                    break;

               case '8':

                    //Please defined clear explanation what to do

                    break;

                case 'Q':

                    long TimeEnding = System.currentTimeMillis();

System.out.println("Thank you for trying the US Crimes Statistics Program.");

                    System.out.println("Elapsed time in seconds was: "

                            + (TimeEnding - TimeStarted) / 100);

                    break;

                default:

                    System.out.println("Enter a valid menu selection");

                }

            }

        } catch (Exception e) {

        }

    }

}