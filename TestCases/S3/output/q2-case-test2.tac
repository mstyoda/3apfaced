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
    _T7 = 3
    _T8 = 0
    _T9 = (_T7 < _T8)
    if (_T9 == 0) branch _L10
    _T10 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T10
    call _PrintString
    call _Halt
_L10:
    _T11 = 4
    _T12 = (_T11 * _T7)
    _T13 = (_T11 + _T12)
    parm _T13
    _T14 =  call _Alloc
    *(_T14 + 0) = _T7
    _T15 = 0
    _T14 = (_T14 + _T13)
_L11:
    _T13 = (_T13 - _T11)
    if (_T13 == 0) branch _L12
    _T14 = (_T14 - _T11)
    *(_T14 + 0) = _T15
    branch _L11
_L12:
    _T16 = 0
    *(_T14 + 4) = _T16
    _T17 = 0
    *(_T14 + 8) = _T17
    _T18 = 6
    _T3 = _T18
    _T19 = 2
    _T4 = _T19
    _T20 = 3
    _T5 = _T20
    _T21 = 3
    _T22 = (_T3 * _T21)
    _T24 = 0
    _T25 = (_T4 + _T5)
    _T23 = _T25
    _T26 = (_T24 == _T22)
    if (_T26 != 0) branch _L13
    _T27 = 3
    _T28 = 3
    _T29 = (_T4 + _T28)
    _T23 = _T29
    _T30 = (_T27 == _T22)
    if (_T30 != 0) branch _L13
    _T31 = 9
    _T32 = 2
    _T33 = (_T5 * _T32)
    _T34 = 6
    _T35 = (_T33 + _T34)
    _T23 = _T35
    _T36 = (_T31 == _T22)
    if (_T36 != 0) branch _L13
    _T37 = 100
    _T23 = _T37
_L13:
    _T4 = _T23
    parm _T4
    call _PrintInt
    _T38 = "\n"
    parm _T38
    call _PrintString
    _T39 = 3
    _T6 = _T39
    _T41 = 0
    _T42 = (_T4 + _T5)
    _T40 = _T42
    _T43 = (_T41 == _T6)
    if (_T43 != 0) branch _L14
    _T44 = 3
    _T45 = 3
    _T46 = (_T4 + _T45)
    _T40 = _T46
    _T47 = (_T44 == _T6)
    if (_T47 != 0) branch _L14
    _T48 = 6
    _T49 = 2
    _T50 = (_T5 * _T49)
    _T51 = 6
    _T52 = (_T50 + _T51)
    _T40 = _T52
    _T53 = (_T48 == _T6)
    if (_T53 != 0) branch _L14
    _T54 = 100
    _T40 = _T54
_L14:
    _T4 = _T40
    parm _T4
    call _PrintInt
    _T55 = "\n"
    parm _T55
    call _PrintString
    _T57 = 0
    _T58 = (_T4 + _T5)
    _T56 = _T58
    _T59 = (_T57 == _T3)
    if (_T59 != 0) branch _L15
    _T60 = 3
    _T61 = 3
    _T62 = (_T4 + _T61)
    _T56 = _T62
    _T63 = (_T60 == _T3)
    if (_T63 != 0) branch _L15
    _T64 = 6
    _T65 = 2
    _T66 = (_T5 * _T65)
    _T67 = 6
    _T68 = (_T66 + _T67)
    _T56 = _T68
    _T69 = (_T64 == _T3)
    if (_T69 != 0) branch _L15
    _T70 = 100
    _T56 = _T70
_L15:
    _T4 = _T56
    parm _T4
    call _PrintInt
    _T71 = "\n"
    parm _T71
    call _PrintString
    _T72 = 6
    _T73 = (_T3 - _T72)
    _T75 = 0
    _T76 = (_T4 + _T5)
    _T74 = _T76
    _T77 = (_T75 == _T73)
    if (_T77 != 0) branch _L16
    _T78 = 3
    _T79 = 3
    _T80 = (_T4 + _T79)
    _T74 = _T80
    _T81 = (_T78 == _T73)
    if (_T81 != 0) branch _L16
    _T82 = 9
    _T83 = 2
    _T84 = (_T5 * _T83)
    _T85 = 6
    _T86 = (_T84 + _T85)
    _T74 = _T86
    _T87 = (_T82 == _T73)
    if (_T87 != 0) branch _L16
    _T88 = 100
    _T74 = _T88
_L16:
    _T4 = _T74
    parm _T4
    call _PrintInt
    _T89 = "\n"
    parm _T89
    call _PrintString
    _T91 = 0
    _T92 = (_T4 + _T5)
    _T90 = _T92
    _T93 = (_T91 == _T3)
    if (_T93 != 0) branch _L17
    _T94 = 3
    _T95 = 3
    _T96 = (_T4 + _T95)
    _T90 = _T96
    _T97 = (_T94 == _T3)
    if (_T97 != 0) branch _L17
    _T98 = 6
    _T99 = 2
    _T100 = (_T5 * _T99)
    _T101 = 6
    _T102 = (_T100 + _T101)
    _T90 = _T102
    _T103 = (_T98 == _T3)
    if (_T103 != 0) branch _L17
    _T104 = 100
    _T90 = _T104
_L17:
    _T105 = 3
    _T106 = 0
    _T107 = (_T105 < _T106)
    if (_T107 == 0) branch _L18
    _T108 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T108
    call _PrintString
    call _Halt
_L18:
    _T109 = 4
    _T110 = (_T109 * _T105)
    _T111 = (_T109 + _T110)
    parm _T111
    _T112 =  call _Alloc
    *(_T112 + 0) = _T105
    _T113 = 0
    _T112 = (_T112 + _T111)
_L19:
    _T111 = (_T111 - _T109)
    if (_T111 == 0) branch _L20
    _T112 = (_T112 - _T109)
    *(_T112 + 0) = _T113
    branch _L19
_L20:
    _T114 = 0
    *(_T112 + 4) = _T114
    _T115 = 0
    *(_T112 + 8) = _T115
    *(_T112 + 4) = _T90
    _T116 = 0
    *(_T112 + 8) = _T116
    _T117 = *(_T112 + 4)
    *(_T14 + 4) = _T117
    _T118 = *(_T112 + 8)
    *(_T14 + 8) = _T118
    _T119 = *(_T14 + 4)
    parm _T119
    call _PrintInt
    _T120 = "+"
    parm _T120
    call _PrintString
    _T121 = *(_T14 + 8)
    parm _T121
    call _PrintInt
    _T122 = "j"
    parm _T122
    call _PrintString
    _T123 = "\n"
    parm _T123
    call _PrintString
    _T125 = 8
    _T126 = (_T4 + _T5)
    _T124 = _T126
    _T127 = (_T125 == _T3)
    if (_T127 != 0) branch _L21
    _T128 = 3
    _T129 = (_T4 + _T3)
    _T124 = _T129
    _T130 = (_T128 == _T3)
    if (_T130 != 0) branch _L21
    _T131 = 0
    _T132 = 8
    _T124 = _T132
    _T133 = (_T131 == _T3)
    if (_T133 != 0) branch _L21
    _T134 = 100
    _T124 = _T134
_L21:
    _T135 = 3
    _T136 = 0
    _T137 = (_T135 < _T136)
    if (_T137 == 0) branch _L22
    _T138 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T138
    call _PrintString
    call _Halt
_L22:
    _T139 = 4
    _T140 = (_T139 * _T135)
    _T141 = (_T139 + _T140)
    parm _T141
    _T142 =  call _Alloc
    *(_T142 + 0) = _T135
    _T143 = 0
    _T142 = (_T142 + _T141)
_L23:
    _T141 = (_T141 - _T139)
    if (_T141 == 0) branch _L24
    _T142 = (_T142 - _T139)
    *(_T142 + 0) = _T143
    branch _L23
_L24:
    _T144 = 0
    *(_T142 + 4) = _T144
    _T145 = 0
    *(_T142 + 8) = _T145
    *(_T142 + 4) = _T124
    _T146 = 0
    *(_T142 + 8) = _T146
    _T147 = *(_T142 + 4)
    *(_T14 + 4) = _T147
    _T148 = *(_T142 + 8)
    *(_T14 + 8) = _T148
    _T149 = *(_T14 + 4)
    parm _T149
    call _PrintInt
    _T150 = "+"
    parm _T150
    call _PrintString
    _T151 = *(_T14 + 8)
    parm _T151
    call _PrintInt
    _T152 = "j"
    parm _T152
    call _PrintString
    _T153 = "\n"
    parm _T153
    call _PrintString
}

