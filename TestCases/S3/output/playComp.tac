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
    _T35 = 12
    *(_T32 + 8) = _T35
    _T36 = *(_T32 + 4)
    *(_T10 + 4) = _T36
    _T37 = *(_T32 + 8)
    *(_T10 + 8) = _T37
    _T38 = *(_T10 + 4)
    parm _T38
    call _PrintInt
    _T39 = "+"
    parm _T39
    call _PrintString
    _T40 = *(_T10 + 8)
    parm _T40
    call _PrintInt
    _T41 = "j"
    parm _T41
    call _PrintString
    _T42 = "\n"
    parm _T42
    call _PrintString
    _T43 = 3
    _T44 = 0
    _T45 = (_T43 < _T44)
    if (_T45 == 0) branch _L19
    _T46 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T46
    call _PrintString
    call _Halt
_L19:
    _T47 = 4
    _T48 = (_T47 * _T43)
    _T49 = (_T47 + _T48)
    parm _T49
    _T50 =  call _Alloc
    *(_T50 + 0) = _T43
    _T51 = 0
    _T50 = (_T50 + _T49)
_L20:
    _T49 = (_T49 - _T47)
    if (_T49 == 0) branch _L21
    _T50 = (_T50 - _T47)
    *(_T50 + 0) = _T51
    branch _L20
_L21:
    _T52 = 0
    *(_T50 + 4) = _T52
    _T53 = 45
    *(_T50 + 8) = _T53
    _T54 = *(_T50 + 4)
    *(_T21 + 4) = _T54
    _T55 = *(_T50 + 8)
    *(_T21 + 8) = _T55
    _T56 = 3
    _T57 = 0
    _T58 = (_T56 < _T57)
    if (_T58 == 0) branch _L22
    _T59 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T59
    call _PrintString
    call _Halt
_L22:
    _T60 = 4
    _T61 = (_T60 * _T56)
    _T62 = (_T60 + _T61)
    parm _T62
    _T63 =  call _Alloc
    *(_T63 + 0) = _T56
    _T64 = 0
    _T63 = (_T63 + _T62)
_L23:
    _T62 = (_T62 - _T60)
    if (_T62 == 0) branch _L24
    _T63 = (_T63 - _T60)
    *(_T63 + 0) = _T64
    branch _L23
_L24:
    _T65 = 0
    *(_T63 + 4) = _T65
    _T66 = 45
    *(_T63 + 8) = _T66
    _T67 = *(_T63 + 4)
    parm _T67
    call _PrintInt
    _T68 = "+"
    parm _T68
    call _PrintString
    _T69 = *(_T63 + 8)
    parm _T69
    call _PrintInt
    _T70 = "j"
    parm _T70
    call _PrintString
    _T71 = "\n"
    parm _T71
    call _PrintString
    _T72 = *(_T10 + 4)
    parm _T72
    call _PrintInt
    _T73 = "+"
    parm _T73
    call _PrintString
    _T74 = *(_T10 + 8)
    parm _T74
    call _PrintInt
    _T75 = "j"
    parm _T75
    call _PrintString
}

