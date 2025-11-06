package org.science.prismatics.dto.response;

import org.science.prismatics.entity.Colors;

public record ColorResponse(
        Short red,
        Short green,
        Short blue
) {
    public static ColorResponse from(Colors color) {
        return new ColorResponse(
                color.getRed(),
                color.getGreen(),
                color.getBlue()
        );
    }
}
