//package com.javarush.test.level23.lesson06.task02;
//
///* Рефакторинг
//Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
//Запретите наследоваться от Constants.
//*/
//public class Solution {
//
//    public static final class Constants {
//        static final String constant1 = "Server is not accessible for now.";
//        static final String constant2 = "User is not authorized.";
//        static final String constant3 = "User is banned.";
//        static final String constant4 = "Access is denied.";
//    }
//
//    public class ServerNotAccessibleException extends Exception {
//        public ServerNotAccessibleException() {
//            super(Constants.constant1);
//        }
//
//        public ServerNotAccessibleException(Throwable cause) {
//            super(Constants.constant1, cause);
//        }
//    }
//
//    public class UnauthorizedUserException extends Exception {
//        public UnauthorizedUserException() {
//            super(Constants.constant2);
//        }
//
//        public UnauthorizedUserException(Throwable cause) {
//            super(Constants.constant2, cause);
//        }
//    }
//
//    public class BannedUserException extends Exception {
//        public BannedUserException() {
//            super(Constants.constant3);
//        }
//
//        public BannedUserException(Throwable cause) {
//            super(Constants.constant3, cause);
//        }
//    }
//
//    public class RestrictionException extends Exception {
//        public RestrictionException() {
//            super(Constants.constant4);
//        }
//
//        public RestrictionException(Throwable cause) {
//            super(Constants.constant4, cause);
//        }
//    }
//}
