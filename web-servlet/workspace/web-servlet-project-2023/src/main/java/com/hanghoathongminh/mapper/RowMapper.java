package com.hanghoathongminh.mapper;

import java.sql.ResultSet;

public interface RowMapper<T> {
	T mapRow(ResultSet resultSet);
}
