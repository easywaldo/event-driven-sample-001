CREATE TABLE user_entity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

-- Author 테이블 생성
CREATE TABLE IF NOT EXISTS authors (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

-- Book 테이블 생성
CREATE TABLE IF NOT EXISTS books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author_id BIGINT,
    FOREIGN KEY (author_id) REFERENCES authors(id) ON DELETE SET NULL -- Author 삭제 시 author_id를 NULL로 설정
);



/****************************
*   Attendance Management System
*   Created by Easywaldo
*   Date: 2025-09-07
*   Description: This script creates tables for managing student attendance records.
****************************/


-- 수강생 테이블 생성
CREATE TABLE IF NOT EXISTS students (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

-- 수업 계획 테이블 생성
CREATE TABLE IF NOT EXISTS lesson_plans (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    student_id BIGINT,
    lesson_start TIMESTAMP NOT NULL,
    lesson_end TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

