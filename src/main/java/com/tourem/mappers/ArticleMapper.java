package com.tourem.mappers;

import com.tourem.dao.entities.ArticleEntity;
import com.tourem.dto.ArticleDto;
import org.apache.logging.log4j.util.Strings;
import org.mapstruct.Mapper;

import javax.sql.rowset.serial.SerialClob;
import java.sql.Clob;


@Mapper(
        componentModel = "spring",
        uses = {
                AuthorMapper.class
        }
)
public interface ArticleMapper extends TouremObjectMapper<ArticleEntity, ArticleDto> {
        default String mapPayloadToString(Clob source) {
                try {
                        if (Math.toIntExact(source.length()) > 0) {
                                return source.getSubString(1, Math.toIntExact(source.length()));
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return Strings.EMPTY;
        }

        default Clob mapPayloadToClob(String source) {
                try {
                        return new SerialClob(source.toCharArray());
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return null;
        }
}
