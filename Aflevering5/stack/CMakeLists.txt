cmake_minimum_required(VERSION 3.21)
project(stack C)

set(CMAKE_C_STANDARD 99)

set(PROJECT_HEADERS stack.h)

set(PROJECT_SOURCES stackMain.c stack.c)

add_executable(stack ${PROJECT_SOURCES} ${PROJECT_HEADERS})