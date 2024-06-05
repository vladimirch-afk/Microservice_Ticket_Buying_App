package ru.hse.ticketsauth.dao

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.DependsOn
import org.springframework.context.annotation.Profile
import org.springframework.core.io.Resource
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.util.FileCopyUtils

@Configuration
//@DependsOn("jdbcTemplate")
@Profile("dev")
class EntitiesToDB(
    val jdbc: JdbcTemplate,
    @Value("classpath:dev/init.sql") sqlInit: Resource
) {
    init {
        sqlInit.inputStream.reader().use {
            jdbc.execute(FileCopyUtils.copyToString(it))
        }
    }
}