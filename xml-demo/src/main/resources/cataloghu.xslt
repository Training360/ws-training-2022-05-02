<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <katalogus>
                    <xsl:for-each select="/catalog/book">
                        <konyv>
                            <xsl:value-of select="title"/>
                        </konyv>
                    </xsl:for-each>
        </katalogus>
    </xsl:template>
</xsl:stylesheet>