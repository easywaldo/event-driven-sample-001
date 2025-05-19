package com.example.demo.infra.repository

import com.example.demo.infra.entity.AuthorEntity
import org.springframework.data.r2dbc.repository.R2dbcRepository


interface AuthorRepository : R2dbcRepository<AuthorEntity, Long>