VTABLE(_Main) {
    <empty>
    Main
}

FUNCTION(_Main_New) {
memo ''
_Main_New:
    _T0 = 4
    parm _T0
    _T1 =  call _Alloc
    _T2 = VTBL <_Main>
    *(_T1 + 0) = _T2
    return _T1
}

FUNCTION(main) {
memo ''
main:
    _T3 = 3
    _T4 = 0
    _T5 = (_T3 < _T4)
    if (_T5 == 0) branch _L10
    _T6 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T6
    call _PrintString
    call _Halt
_L10:
    _T7 = 4
    _T8 = (_T7 * _T3)
    _T9 = (_T7 + _T8)
    parm _T9
    _T10 =  call _Alloc
    *(_T10 + 0) = _T3
    _T11 = 0
    _T10 = (_T10 + _T9)
_L11:
    _T9 = (_T9 - _T7)
    if (_T9 == 0) branch _L12
    _T10 = (_T10 - _T7)
    *(_T10 + 0) = _T11
    branch _L11
_L12:
    _T12 = 0
    *(_T10 + 4) = _T12
    _T13 = 0
    *(_T10 + 8) = _T13
    _T14 = 3
    _T15 = 0
    _T16 = (_T14 < _T15)
    if (_T16 == 0) branch _L13
    _T17 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T17
    call _PrintString
    call _Halt
_L13:
    _T18 = 4
    _T19 = (_T18 * _T14)
    _T20 = (_T18 + _T19)
    parm _T20
    _T21 =  call _Alloc
    *(_T21 + 0) = _T14
    _T22 = 0
    _T21 = (_T21 + _T20)
_L14:
    _T20 = (_T20 - _T18)
    if (_T20 == 0) branch _L15
    _T21 = (_T21 - _T18)
    *(_T21 + 0) = _T22
    branch _L14
_L15:
    _T23 = 0
    *(_T21 + 4) = _T23
    _T24 = 0
    *(_T21 + 8) = _T24
    _T25 = 3
    _T26 = 0
    _T27 = (_T25 < _T26)
    if (_T27 == 0) branch _L16
    _T28 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T28
    call _PrintString
    call _Halt
_L16:
    _T29 = 4
    _T30 = (_T29 * _T25)
    _T31 = (_T29 + _T30)
    parm _T31
    _T32 =  call _Alloc
    *(_T32 + 0) = _T25
    _T33 = 0
    _T32 = (_T32 + _T31)
_L17:
    _T31 = (_T31 - _T29)
    if (_T31 == 0) branch _L18
    _T32 = (_T32 - _T29)
    *(_T32 + 0) = _T33
    branch _L17
_L18:
    _T34 = 0
    *(_T32 + 4) = _T34
    _T35 = 0
    *(_T32 + 8) = _T35
    _T41 = 1
    _T36 = _T41
    parm _T36
    call _PrintInt
    _T42 = "\n"
    parm _T42
    call _PrintString
    _T43 = 3
    _T44 = 3
    _T45 = 0
    _T46 = (_T44 < _T45)
    if (_T46 == 0) branch _L19
    _T47 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T47
    call _PrintString
    call _Halt
_L19:
    _T48 = 4
    _T49 = (_T48 * _T44)
    _T50 = (_T48 + _T49)
    parm _T50
    _T51 =  call _Alloc
    *(_T51 + 0) = _T44
    _T52 = 0
    _T51 = (_T51 + _T50)
_L20:
    _T50 = (_T50 - _T48)
    if (_T50 == 0) branch _L21
    _T51 = (_T51 - _T48)
    *(_T51 + 0) = _T52
    branch _L20
_L21:
    _T53 = 0
    *(_T51 + 4) = _T53
    _T54 = 12
    *(_T51 + 8) = _T54
    _T55 = 3
    _T56 = 0
    _T57 = (_T55 < _T56)
    if (_T57 == 0) branch _L22
    _T58 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T58
    call _PrintString
    call _Halt
_L22:
    _T59 = 4
    _T60 = (_T59 * _T55)
    _T61 = (_T59 + _T60)
    parm _T61
    _T62 =  call _Alloc
    *(_T62 + 0) = _T55
    _T63 = 0
    _T62 = (_T62 + _T61)
_L23:
    _T61 = (_T61 - _T59)
    if (_T61 == 0) branch _L24
    _T62 = (_T62 - _T59)
    *(_T62 + 0) = _T63
    branch _L23
_L24:
    _T64 = 0
    *(_T62 + 4) = _T64
    _T65 = 0
    *(_T62 + 8) = _T65
    *(_T62 + 4) = _T43
    _T66 = 0
    *(_T62 + 8) = _T66
    _T67 = *(_T62 + 4)
    _T68 = *(_T62 + 8)
    _T69 = *(_T51 + 4)
    _T70 = *(_T51 + 8)
    _T71 = 3
    _T72 = 0
    _T73 = (_T71 < _T72)
    if (_T73 == 0) branch _L25
    _T74 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T74
    call _PrintString
    call _Halt
_L25:
    _T75 = 4
    _T76 = (_T75 * _T71)
    _T77 = (_T75 + _T76)
    parm _T77
    _T78 =  call _Alloc
    *(_T78 + 0) = _T71
    _T79 = 0
    _T78 = (_T78 + _T77)
_L26:
    _T77 = (_T77 - _T75)
    if (_T77 == 0) branch _L27
    _T78 = (_T78 - _T75)
    *(_T78 + 0) = _T79
    branch _L26
_L27:
    _T80 = 0
    *(_T78 + 4) = _T80
    _T81 = 0
    *(_T78 + 8) = _T81
    _T82 = (_T67 + _T69)
    *(_T78 + 4) = _T82
    _T83 = (_T68 + _T70)
    *(_T78 + 8) = _T83
    _T84 = *(_T78 + 4)
    *(_T10 + 4) = _T84
    _T85 = *(_T78 + 8)
    *(_T10 + 8) = _T85
    _T86 = *(_T10 + 4)
    parm _T86
    call _PrintInt
    _T87 = "+"
    parm _T87
    call _PrintString
    _T88 = *(_T10 + 8)
    parm _T88
    call _PrintInt
    _T89 = "j"
    parm _T89
    call _PrintString
    _T90 = "\n"
    parm _T90
    call _PrintString
    _T91 = 3
    _T92 = 3
    _T93 = 0
    _T94 = (_T92 < _T93)
    if (_T94 == 0) branch _L28
    _T95 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T95
    call _PrintString
    call _Halt
_L28:
    _T96 = 4
    _T97 = (_T96 * _T92)
    _T98 = (_T96 + _T97)
    parm _T98
    _T99 =  call _Alloc
    *(_T99 + 0) = _T92
    _T100 = 0
    _T99 = (_T99 + _T98)
_L29:
    _T98 = (_T98 - _T96)
    if (_T98 == 0) branch _L30
    _T99 = (_T99 - _T96)
    *(_T99 + 0) = _T100
    branch _L29
_L30:
    _T101 = 0
    *(_T99 + 4) = _T101
    _T102 = 45
    *(_T99 + 8) = _T102
    _T103 = 3
    _T104 = 0
    _T105 = (_T103 < _T104)
    if (_T105 == 0) branch _L31
    _T106 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T106
    call _PrintString
    call _Halt
_L31:
    _T107 = 4
    _T108 = (_T107 * _T103)
    _T109 = (_T107 + _T108)
    parm _T109
    _T110 =  call _Alloc
    *(_T110 + 0) = _T103
    _T111 = 0
    _T110 = (_T110 + _T109)
_L32:
    _T109 = (_T109 - _T107)
    if (_T109 == 0) branch _L33
    _T110 = (_T110 - _T107)
    *(_T110 + 0) = _T111
    branch _L32
_L33:
    _T112 = 0
    *(_T110 + 4) = _T112
    _T113 = 0
    *(_T110 + 8) = _T113
    *(_T110 + 4) = _T91
    _T114 = 0
    *(_T110 + 8) = _T114
    _T115 = *(_T110 + 4)
    _T116 = *(_T110 + 8)
    _T117 = *(_T99 + 4)
    _T118 = *(_T99 + 8)
    _T119 = 3
    _T120 = 0
    _T121 = (_T119 < _T120)
    if (_T121 == 0) branch _L34
    _T122 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T122
    call _PrintString
    call _Halt
_L34:
    _T123 = 4
    _T124 = (_T123 * _T119)
    _T125 = (_T123 + _T124)
    parm _T125
    _T126 =  call _Alloc
    *(_T126 + 0) = _T119
    _T127 = 0
    _T126 = (_T126 + _T125)
_L35:
    _T125 = (_T125 - _T123)
    if (_T125 == 0) branch _L36
    _T126 = (_T126 - _T123)
    *(_T126 + 0) = _T127
    branch _L35
_L36:
    _T128 = 0
    *(_T126 + 4) = _T128
    _T129 = 0
    *(_T126 + 8) = _T129
    _T130 = (_T115 + _T117)
    *(_T126 + 4) = _T130
    _T131 = (_T116 + _T118)
    *(_T126 + 8) = _T131
    _T132 = *(_T126 + 4)
    *(_T32 + 4) = _T132
    _T133 = *(_T126 + 8)
    *(_T32 + 8) = _T133
    _T134 = *(_T10 + 4)
    _T37 = _T134
    _T135 = *(_T10 + 8)
    _T38 = _T135
    parm _T37
    call _PrintInt
    parm _T38
    call _PrintInt
    _T136 = "\n"
    parm _T136
    call _PrintString
    _T137 = (_T37 + _T38)
    _T138 = 3
    _T139 = 0
    _T140 = (_T138 < _T139)
    if (_T140 == 0) branch _L37
    _T141 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T141
    call _PrintString
    call _Halt
_L37:
    _T142 = 4
    _T143 = (_T142 * _T138)
    _T144 = (_T142 + _T143)
    parm _T144
    _T145 =  call _Alloc
    *(_T145 + 0) = _T138
    _T146 = 0
    _T145 = (_T145 + _T144)
_L38:
    _T144 = (_T144 - _T142)
    if (_T144 == 0) branch _L39
    _T145 = (_T145 - _T142)
    *(_T145 + 0) = _T146
    branch _L38
_L39:
    _T147 = 0
    *(_T145 + 4) = _T147
    _T148 = 0
    *(_T145 + 8) = _T148
    *(_T145 + 4) = _T137
    _T149 = 0
    *(_T145 + 8) = _T149
    _T150 = *(_T145 + 4)
    *(_T21 + 4) = _T150
    _T151 = *(_T145 + 8)
    *(_T21 + 8) = _T151
    _T152 = *(_T21 + 4)
    parm _T152
    call _PrintInt
    _T153 = "+"
    parm _T153
    call _PrintString
    _T154 = *(_T21 + 8)
    parm _T154
    call _PrintInt
    _T155 = "j"
    parm _T155
    call _PrintString
    _T156 = "\n"
    parm _T156
    call _PrintString
    _T157 = *(_T10 + 4)
    _T158 = *(_T10 + 8)
    _T159 = *(_T21 + 4)
    _T160 = *(_T21 + 8)
    _T161 = 3
    _T162 = 0
    _T163 = (_T161 < _T162)
    if (_T163 == 0) branch _L40
    _T164 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T164
    call _PrintString
    call _Halt
_L40:
    _T165 = 4
    _T166 = (_T165 * _T161)
    _T167 = (_T165 + _T166)
    parm _T167
    _T168 =  call _Alloc
    *(_T168 + 0) = _T161
    _T169 = 0
    _T168 = (_T168 + _T167)
_L41:
    _T167 = (_T167 - _T165)
    if (_T167 == 0) branch _L42
    _T168 = (_T168 - _T165)
    *(_T168 + 0) = _T169
    branch _L41
_L42:
    _T170 = 0
    *(_T168 + 4) = _T170
    _T171 = 0
    *(_T168 + 8) = _T171
    _T172 = (_T157 + _T159)
    *(_T168 + 4) = _T172
    _T173 = (_T158 + _T160)
    *(_T168 + 8) = _T173
    _T174 = *(_T168 + 4)
    parm _T174
    call _PrintInt
    _T175 = "+"
    parm _T175
    call _PrintString
    _T176 = *(_T168 + 8)
    parm _T176
    call _PrintInt
    _T177 = "j"
    parm _T177
    call _PrintString
    _T178 = "\n"
    parm _T178
    call _PrintString
    _T179 = *(_T10 + 4)
    _T180 = *(_T10 + 8)
    _T181 = *(_T21 + 4)
    _T182 = *(_T21 + 8)
    _T183 = 3
    _T184 = 0
    _T185 = (_T183 < _T184)
    if (_T185 == 0) branch _L43
    _T186 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T186
    call _PrintString
    call _Halt
_L43:
    _T187 = 4
    _T188 = (_T187 * _T183)
    _T189 = (_T187 + _T188)
    parm _T189
    _T190 =  call _Alloc
    *(_T190 + 0) = _T183
    _T191 = 0
    _T190 = (_T190 + _T189)
_L44:
    _T189 = (_T189 - _T187)
    if (_T189 == 0) branch _L45
    _T190 = (_T190 - _T187)
    *(_T190 + 0) = _T191
    branch _L44
_L45:
    _T192 = 0
    *(_T190 + 4) = _T192
    _T193 = 0
    *(_T190 + 8) = _T193
    _T194 = (_T179 + _T181)
    *(_T190 + 4) = _T194
    _T195 = (_T180 + _T182)
    *(_T190 + 8) = _T195
    _T196 = *(_T190 + 4)
    parm _T196
    call _PrintInt
    _T197 = "+"
    parm _T197
    call _PrintString
    _T198 = *(_T190 + 8)
    parm _T198
    call _PrintInt
    _T199 = "j"
    parm _T199
    call _PrintString
    _T200 = *(_T32 + 4)
    parm _T200
    call _PrintInt
    _T201 = "+"
    parm _T201
    call _PrintString
    _T202 = *(_T32 + 8)
    parm _T202
    call _PrintInt
    _T203 = "j"
    parm _T203
    call _PrintString
    _T204 = "\n"
    parm _T204
    call _PrintString
    _T205 = *(_T10 + 4)
    _T206 = *(_T10 + 8)
    _T207 = *(_T21 + 4)
    _T208 = *(_T21 + 8)
    _T209 = 3
    _T210 = 0
    _T211 = (_T209 < _T210)
    if (_T211 == 0) branch _L46
    _T212 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T212
    call _PrintString
    call _Halt
_L46:
    _T213 = 4
    _T214 = (_T213 * _T209)
    _T215 = (_T213 + _T214)
    parm _T215
    _T216 =  call _Alloc
    *(_T216 + 0) = _T209
    _T217 = 0
    _T216 = (_T216 + _T215)
_L47:
    _T215 = (_T215 - _T213)
    if (_T215 == 0) branch _L48
    _T216 = (_T216 - _T213)
    *(_T216 + 0) = _T217
    branch _L47
_L48:
    _T218 = 0
    *(_T216 + 4) = _T218
    _T219 = 0
    *(_T216 + 8) = _T219
    _T220 = (_T205 + _T207)
    *(_T216 + 4) = _T220
    _T221 = (_T206 + _T208)
    *(_T216 + 8) = _T221
    _T222 = *(_T216 + 4)
    *(_T32 + 4) = _T222
    _T223 = *(_T216 + 8)
    *(_T32 + 8) = _T223
    _T224 = 3
    _T225 = 0
    _T226 = (_T224 < _T225)
    if (_T226 == 0) branch _L49
    _T227 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T227
    call _PrintString
    call _Halt
_L49:
    _T228 = 4
    _T229 = (_T228 * _T224)
    _T230 = (_T228 + _T229)
    parm _T230
    _T231 =  call _Alloc
    *(_T231 + 0) = _T224
    _T232 = 0
    _T231 = (_T231 + _T230)
_L50:
    _T230 = (_T230 - _T228)
    if (_T230 == 0) branch _L51
    _T231 = (_T231 - _T228)
    *(_T231 + 0) = _T232
    branch _L50
_L51:
    _T233 = 0
    *(_T231 + 4) = _T233
    _T234 = 0
    *(_T231 + 8) = _T234
    *(_T231 + 4) = _T37
    _T235 = 0
    *(_T231 + 8) = _T235
    _T236 = *(_T10 + 4)
    _T237 = *(_T10 + 8)
    _T238 = *(_T231 + 4)
    _T239 = *(_T231 + 8)
    _T240 = 3
    _T241 = 0
    _T242 = (_T240 < _T241)
    if (_T242 == 0) branch _L52
    _T243 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T243
    call _PrintString
    call _Halt
_L52:
    _T244 = 4
    _T245 = (_T244 * _T240)
    _T246 = (_T244 + _T245)
    parm _T246
    _T247 =  call _Alloc
    *(_T247 + 0) = _T240
    _T248 = 0
    _T247 = (_T247 + _T246)
_L53:
    _T246 = (_T246 - _T244)
    if (_T246 == 0) branch _L54
    _T247 = (_T247 - _T244)
    *(_T247 + 0) = _T248
    branch _L53
_L54:
    _T249 = 0
    *(_T247 + 4) = _T249
    _T250 = 0
    *(_T247 + 8) = _T250
    _T251 = (_T236 + _T238)
    *(_T247 + 4) = _T251
    _T252 = (_T237 + _T239)
    *(_T247 + 8) = _T252
    _T253 = *(_T247 + 4)
    *(_T32 + 4) = _T253
    _T254 = *(_T247 + 8)
    *(_T32 + 8) = _T254
    _T255 = 3
    _T256 = 0
    _T257 = (_T255 < _T256)
    if (_T257 == 0) branch _L55
    _T258 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T258
    call _PrintString
    call _Halt
_L55:
    _T259 = 4
    _T260 = (_T259 * _T255)
    _T261 = (_T259 + _T260)
    parm _T261
    _T262 =  call _Alloc
    *(_T262 + 0) = _T255
    _T263 = 0
    _T262 = (_T262 + _T261)
_L56:
    _T261 = (_T261 - _T259)
    if (_T261 == 0) branch _L57
    _T262 = (_T262 - _T259)
    *(_T262 + 0) = _T263
    branch _L56
_L57:
    _T264 = 0
    *(_T262 + 4) = _T264
    _T265 = 0
    *(_T262 + 8) = _T265
    _T266 = *(_T10 + 4)
    _T267 = *(_T10 + 8)
    _T268 = *(_T262 + 4)
    _T269 = *(_T262 + 8)
    _T270 = 3
    _T271 = 0
    _T272 = (_T270 < _T271)
    if (_T272 == 0) branch _L58
    _T273 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T273
    call _PrintString
    call _Halt
_L58:
    _T274 = 4
    _T275 = (_T274 * _T270)
    _T276 = (_T274 + _T275)
    parm _T276
    _T277 =  call _Alloc
    *(_T277 + 0) = _T270
    _T278 = 0
    _T277 = (_T277 + _T276)
_L59:
    _T276 = (_T276 - _T274)
    if (_T276 == 0) branch _L60
    _T277 = (_T277 - _T274)
    *(_T277 + 0) = _T278
    branch _L59
_L60:
    _T279 = 0
    *(_T277 + 4) = _T279
    _T280 = 0
    *(_T277 + 8) = _T280
    _T281 = (_T266 + _T268)
    *(_T277 + 4) = _T281
    _T282 = (_T267 + _T269)
    *(_T277 + 8) = _T282
    _T283 = *(_T277 + 4)
    *(_T32 + 4) = _T283
    _T284 = *(_T277 + 8)
    *(_T32 + 8) = _T284
    _T285 = 3
    _T286 = 0
    _T287 = (_T285 < _T286)
    if (_T287 == 0) branch _L61
    _T288 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T288
    call _PrintString
    call _Halt
_L61:
    _T289 = 4
    _T290 = (_T289 * _T285)
    _T291 = (_T289 + _T290)
    parm _T291
    _T292 =  call _Alloc
    *(_T292 + 0) = _T285
    _T293 = 0
    _T292 = (_T292 + _T291)
_L62:
    _T291 = (_T291 - _T289)
    if (_T291 == 0) branch _L63
    _T292 = (_T292 - _T289)
    *(_T292 + 0) = _T293
    branch _L62
_L63:
    _T294 = 0
    *(_T292 + 4) = _T294
    _T295 = 0
    *(_T292 + 8) = _T295
    _T296 = 3
    _T297 = 0
    _T298 = (_T296 < _T297)
    if (_T298 == 0) branch _L64
    _T299 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T299
    call _PrintString
    call _Halt
_L64:
    _T300 = 4
    _T301 = (_T300 * _T296)
    _T302 = (_T300 + _T301)
    parm _T302
    _T303 =  call _Alloc
    *(_T303 + 0) = _T296
    _T304 = 0
    _T303 = (_T303 + _T302)
_L65:
    _T302 = (_T302 - _T300)
    if (_T302 == 0) branch _L66
    _T303 = (_T303 - _T300)
    *(_T303 + 0) = _T304
    branch _L65
_L66:
    _T305 = 0
    *(_T303 + 4) = _T305
    _T306 = 0
    *(_T303 + 8) = _T306
    *(_T303 + 4) = _T37
    _T307 = 0
    *(_T303 + 8) = _T307
    _T308 = *(_T292 + 4)
    _T309 = *(_T292 + 8)
    _T310 = *(_T303 + 4)
    _T311 = *(_T303 + 8)
    _T312 = 3
    _T313 = 0
    _T314 = (_T312 < _T313)
    if (_T314 == 0) branch _L67
    _T315 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T315
    call _PrintString
    call _Halt
_L67:
    _T316 = 4
    _T317 = (_T316 * _T312)
    _T318 = (_T316 + _T317)
    parm _T318
    _T319 =  call _Alloc
    *(_T319 + 0) = _T312
    _T320 = 0
    _T319 = (_T319 + _T318)
_L68:
    _T318 = (_T318 - _T316)
    if (_T318 == 0) branch _L69
    _T319 = (_T319 - _T316)
    *(_T319 + 0) = _T320
    branch _L68
_L69:
    _T321 = 0
    *(_T319 + 4) = _T321
    _T322 = 0
    *(_T319 + 8) = _T322
    _T323 = (_T308 + _T310)
    *(_T319 + 4) = _T323
    _T324 = (_T309 + _T311)
    *(_T319 + 8) = _T324
    _T325 = *(_T319 + 4)
    *(_T32 + 4) = _T325
    _T326 = *(_T319 + 8)
    *(_T32 + 8) = _T326
    _T327 = 4
    _T328 = (_T327 + _T37)
    _T40 = _T328
    parm _T40
    call _PrintInt
    _T329 = "\n"
    parm _T329
    call _PrintString
    _T330 = *(_T32 + 4)
    parm _T330
    call _PrintInt
    _T331 = "+"
    parm _T331
    call _PrintString
    _T332 = *(_T32 + 8)
    parm _T332
    call _PrintInt
    _T333 = "j"
    parm _T333
    call _PrintString
    _T334 = "\n"
    parm _T334
    call _PrintString
    _T335 = *(_T10 + 4)
    _T336 = *(_T10 + 8)
    _T337 = *(_T21 + 4)
    _T338 = *(_T21 + 8)
    _T339 = 3
    _T340 = 0
    _T341 = (_T339 < _T340)
    if (_T341 == 0) branch _L70
    _T342 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T342
    call _PrintString
    call _Halt
_L70:
    _T343 = 4
    _T344 = (_T343 * _T339)
    _T345 = (_T343 + _T344)
    parm _T345
    _T346 =  call _Alloc
    *(_T346 + 0) = _T339
    _T347 = 0
    _T346 = (_T346 + _T345)
_L71:
    _T345 = (_T345 - _T343)
    if (_T345 == 0) branch _L72
    _T346 = (_T346 - _T343)
    *(_T346 + 0) = _T347
    branch _L71
_L72:
    _T348 = 0
    *(_T346 + 4) = _T348
    _T349 = 0
    *(_T346 + 8) = _T349
    _T350 = (_T335 * _T337)
    _T351 = (_T336 * _T338)
    _T352 = (_T350 - _T351)
    *(_T346 + 4) = _T352
    _T353 = (_T335 * _T338)
    _T354 = (_T336 * _T337)
    _T355 = (_T353 + _T354)
    *(_T346 + 8) = _T355
    _T356 = *(_T346 + 4)
    *(_T32 + 4) = _T356
    _T357 = *(_T346 + 8)
    *(_T32 + 8) = _T357
    _T358 = 3
    _T359 = 0
    _T360 = (_T358 < _T359)
    if (_T360 == 0) branch _L73
    _T361 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T361
    call _PrintString
    call _Halt
_L73:
    _T362 = 4
    _T363 = (_T362 * _T358)
    _T364 = (_T362 + _T363)
    parm _T364
    _T365 =  call _Alloc
    *(_T365 + 0) = _T358
    _T366 = 0
    _T365 = (_T365 + _T364)
_L74:
    _T364 = (_T364 - _T362)
    if (_T364 == 0) branch _L75
    _T365 = (_T365 - _T362)
    *(_T365 + 0) = _T366
    branch _L74
_L75:
    _T367 = 0
    *(_T365 + 4) = _T367
    _T368 = 0
    *(_T365 + 8) = _T368
    *(_T365 + 4) = _T37
    _T369 = 0
    *(_T365 + 8) = _T369
    _T370 = *(_T10 + 4)
    _T371 = *(_T10 + 8)
    _T372 = *(_T365 + 4)
    _T373 = *(_T365 + 8)
    _T374 = 3
    _T375 = 0
    _T376 = (_T374 < _T375)
    if (_T376 == 0) branch _L76
    _T377 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T377
    call _PrintString
    call _Halt
_L76:
    _T378 = 4
    _T379 = (_T378 * _T374)
    _T380 = (_T378 + _T379)
    parm _T380
    _T381 =  call _Alloc
    *(_T381 + 0) = _T374
    _T382 = 0
    _T381 = (_T381 + _T380)
_L77:
    _T380 = (_T380 - _T378)
    if (_T380 == 0) branch _L78
    _T381 = (_T381 - _T378)
    *(_T381 + 0) = _T382
    branch _L77
_L78:
    _T383 = 0
    *(_T381 + 4) = _T383
    _T384 = 0
    *(_T381 + 8) = _T384
    _T385 = (_T370 * _T372)
    _T386 = (_T371 * _T373)
    _T387 = (_T385 - _T386)
    *(_T381 + 4) = _T387
    _T388 = (_T370 * _T373)
    _T389 = (_T371 * _T372)
    _T390 = (_T388 + _T389)
    *(_T381 + 8) = _T390
    _T391 = *(_T381 + 4)
    *(_T32 + 4) = _T391
    _T392 = *(_T381 + 8)
    *(_T32 + 8) = _T392
    _T393 = 3
    _T394 = 0
    _T395 = (_T393 < _T394)
    if (_T395 == 0) branch _L79
    _T396 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T396
    call _PrintString
    call _Halt
_L79:
    _T397 = 4
    _T398 = (_T397 * _T393)
    _T399 = (_T397 + _T398)
    parm _T399
    _T400 =  call _Alloc
    *(_T400 + 0) = _T393
    _T401 = 0
    _T400 = (_T400 + _T399)
_L80:
    _T399 = (_T399 - _T397)
    if (_T399 == 0) branch _L81
    _T400 = (_T400 - _T397)
    *(_T400 + 0) = _T401
    branch _L80
_L81:
    _T402 = 0
    *(_T400 + 4) = _T402
    _T403 = 0
    *(_T400 + 8) = _T403
    _T404 = *(_T10 + 4)
    _T405 = *(_T10 + 8)
    _T406 = *(_T400 + 4)
    _T407 = *(_T400 + 8)
    _T408 = 3
    _T409 = 0
    _T410 = (_T408 < _T409)
    if (_T410 == 0) branch _L82
    _T411 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T411
    call _PrintString
    call _Halt
_L82:
    _T412 = 4
    _T413 = (_T412 * _T408)
    _T414 = (_T412 + _T413)
    parm _T414
    _T415 =  call _Alloc
    *(_T415 + 0) = _T408
    _T416 = 0
    _T415 = (_T415 + _T414)
_L83:
    _T414 = (_T414 - _T412)
    if (_T414 == 0) branch _L84
    _T415 = (_T415 - _T412)
    *(_T415 + 0) = _T416
    branch _L83
_L84:
    _T417 = 0
    *(_T415 + 4) = _T417
    _T418 = 0
    *(_T415 + 8) = _T418
    _T419 = (_T404 * _T406)
    _T420 = (_T405 * _T407)
    _T421 = (_T419 - _T420)
    *(_T415 + 4) = _T421
    _T422 = (_T404 * _T407)
    _T423 = (_T405 * _T406)
    _T424 = (_T422 + _T423)
    *(_T415 + 8) = _T424
    _T425 = *(_T415 + 4)
    *(_T32 + 4) = _T425
    _T426 = *(_T415 + 8)
    *(_T32 + 8) = _T426
    _T427 = 3
    _T428 = 0
    _T429 = (_T427 < _T428)
    if (_T429 == 0) branch _L85
    _T430 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T430
    call _PrintString
    call _Halt
_L85:
    _T431 = 4
    _T432 = (_T431 * _T427)
    _T433 = (_T431 + _T432)
    parm _T433
    _T434 =  call _Alloc
    *(_T434 + 0) = _T427
    _T435 = 0
    _T434 = (_T434 + _T433)
_L86:
    _T433 = (_T433 - _T431)
    if (_T433 == 0) branch _L87
    _T434 = (_T434 - _T431)
    *(_T434 + 0) = _T435
    branch _L86
_L87:
    _T436 = 0
    *(_T434 + 4) = _T436
    _T437 = 0
    *(_T434 + 8) = _T437
    _T438 = 3
    _T439 = 0
    _T440 = (_T438 < _T439)
    if (_T440 == 0) branch _L88
    _T441 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T441
    call _PrintString
    call _Halt
_L88:
    _T442 = 4
    _T443 = (_T442 * _T438)
    _T444 = (_T442 + _T443)
    parm _T444
    _T445 =  call _Alloc
    *(_T445 + 0) = _T438
    _T446 = 0
    _T445 = (_T445 + _T444)
_L89:
    _T444 = (_T444 - _T442)
    if (_T444 == 0) branch _L90
    _T445 = (_T445 - _T442)
    *(_T445 + 0) = _T446
    branch _L89
_L90:
    _T447 = 0
    *(_T445 + 4) = _T447
    _T448 = 0
    *(_T445 + 8) = _T448
    *(_T445 + 4) = _T37
    _T449 = 0
    *(_T445 + 8) = _T449
    _T450 = *(_T434 + 4)
    _T451 = *(_T434 + 8)
    _T452 = *(_T445 + 4)
    _T453 = *(_T445 + 8)
    _T454 = 3
    _T455 = 0
    _T456 = (_T454 < _T455)
    if (_T456 == 0) branch _L91
    _T457 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T457
    call _PrintString
    call _Halt
_L91:
    _T458 = 4
    _T459 = (_T458 * _T454)
    _T460 = (_T458 + _T459)
    parm _T460
    _T461 =  call _Alloc
    *(_T461 + 0) = _T454
    _T462 = 0
    _T461 = (_T461 + _T460)
_L92:
    _T460 = (_T460 - _T458)
    if (_T460 == 0) branch _L93
    _T461 = (_T461 - _T458)
    *(_T461 + 0) = _T462
    branch _L92
_L93:
    _T463 = 0
    *(_T461 + 4) = _T463
    _T464 = 0
    *(_T461 + 8) = _T464
    _T465 = (_T450 * _T452)
    _T466 = (_T451 * _T453)
    _T467 = (_T465 - _T466)
    *(_T461 + 4) = _T467
    _T468 = (_T450 * _T453)
    _T469 = (_T451 * _T452)
    _T470 = (_T468 + _T469)
    *(_T461 + 8) = _T470
    _T471 = *(_T461 + 4)
    *(_T32 + 4) = _T471
    _T472 = *(_T461 + 8)
    *(_T32 + 8) = _T472
    _T473 = 4
    _T474 = (_T473 * _T37)
    _T40 = _T474
    parm _T40
    call _PrintInt
    _T475 = "\n"
    parm _T475
    call _PrintString
    _T476 = *(_T32 + 4)
    parm _T476
    call _PrintInt
    _T477 = "+"
    parm _T477
    call _PrintString
    _T478 = *(_T32 + 8)
    parm _T478
    call _PrintInt
    _T479 = "j"
    parm _T479
    call _PrintString
    _T480 = "\n"
    parm _T480
    call _PrintString
}

