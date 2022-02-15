package com.igrejaibc.sgi.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {

    private static final Logger LOGGER = Logger.getLogger(Utils.class.getName());

    public static String converterDataFormatoBR(String dataBanco) {
        try {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(dataBanco);
            return formato.format(data);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, e.getMessage());
            throw new RuntimeException("Erro ao tentar converter o formado da data", e);
        }

    }
}
