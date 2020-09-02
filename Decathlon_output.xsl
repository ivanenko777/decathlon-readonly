<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>Decathlon results</h2>
                <table border="1" >
                    <tr bgcolor="#9acd32">
                        <th style="text-align:left">Place</th>
                        <th style="text-align:left">Score</th>
                        <th style="text-align:left">Name</th>
                        <th style="text-align:left" colspan="2">100 m</th>
                        <th style="text-align:left" colspan="2">Long jump</th>
                        <th style="text-align:left" colspan="2">Shot put</th>
                        <th style="text-align:left" colspan="2">High jump</th>
                        <th style="text-align:left" colspan="2">400 m</th>
                        <th style="text-align:left" colspan="2">110 m hurdles</th>
                        <th style="text-align:left" colspan="2">Discus throw</th>
                        <th style="text-align:left" colspan="2">Pole vault</th>
                        <th style="text-align:left" colspan="2">Javelin throw</th>
                        <th style="text-align:left" colspan="2">1500 m</th>
                    </tr>
                    <xsl:for-each select="competition/athletes/athlete">
                        <tr>
                            <td>
                                <xsl:value-of select="place"/>
                            </td>
                            <td>
                                <xsl:value-of select="total_score"/>
                            </td>
                            <td>
                                <xsl:value-of select="name"/>
                            </td>
                            <xsl:for-each select="events/event">
                                <td>
                                    <xsl:value-of select="@performance"/>
                                </td>
                                <td>
                                    <xsl:value-of select="@score"/>
                                </td>
                            </xsl:for-each>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
