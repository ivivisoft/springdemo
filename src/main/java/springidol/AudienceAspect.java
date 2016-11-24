/*
 *  Copyright (c) 2016, 张威, ivivisoft@gmail.com
 *  
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package springidol;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AudienceAspect {

    @Pointcut("execution(* springidol.Performer.perform(..))")
    public void performance() {

    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("The audience is taking their seats.");
    }

    @Before("performance()")
    public void turnOffCellPhones() {
        System.out.println("The audience is turning off their telephone");
    }

    @AfterReturning("performance()")
    public void applaud() {
        System.out.println("CLAP CLAP CLAP CLAP CLAP");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Boo! We want our money back!");
    }

//    @Around("performance()")
//    public void watchPerformance(ProceedingJoinPoint joinPoint) {
//        try {
//            System.out.println("The audience is taking their seats.");
//            System.out.println("The audience is turning off their cellphones");
//            long start = System.currentTimeMillis();
//            joinPoint.proceed();
//            long end = System.currentTimeMillis();
//            System.out.println("CLAP CLAP CLAP CLAP CLAP");
//            System.out.println("The performance took " + (end - start) + " milliseconds.");
//        } catch (Throwable e) {
//            System.out.println("Boo! We want our money back!");
//        }
//    }
}
