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
    _T6 = 3
    _T7 = 0
    _T8 = (_T6 < _T7)
    if (_T8 == 0) branch _L10
    _T9 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T9
    call _PrintString
    call _Halt
_L10:
    _T10 = 4
    _T11 = (_T10 * _T6)
    _T12 = (_T10 + _T11)
    parm _T12
    _T13 =  call _Alloc
    *(_T13 + 0) = _T6
    _T14 = 0
    _T13 = (_T13 + _T12)
_L11:
    _T12 = (_T12 - _T10)
    if (_T12 == 0) branch _L12
    _T13 = (_T13 - _T10)
    *(_T13 + 0) = _T14
    branch _L11
_L12:
    _T15 = 0
    *(_T13 + 4) = _T15
    _T16 = 0
    *(_T13 + 8) = _T16
    _T17 = 1
    _T5 = _T17
    _T18 = "wow!"
    _T4 = _T18
    _T19 = 3
    _T3 = _T19
    _T20 = 1
    _T21 = 3
    _T22 = 0
    _T23 = (_T21 < _T22)
    if (_T23 == 0) branch _L13
    _T24 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T24
    call _PrintString
    call _Halt
_L13:
    _T25 = 4
    _T26 = (_T25 * _T21)
    _T27 = (_T25 + _T26)
    parm _T27
    _T28 =  call _Alloc
    *(_T28 + 0) = _T21
    _T29 = 0
    _T28 = (_T28 + _T27)
_L14:
    _T27 = (_T27 - _T25)
    if (_T27 == 0) branch _L15
    _T28 = (_T28 - _T25)
    *(_T28 + 0) = _T29
    branch _L14
_L15:
    _T30 = 0
    *(_T28 + 4) = _T30
    _T31 = 3
    *(_T28 + 8) = _T31
    _T32 = 3
    _T33 = 0
    _T34 = (_T32 < _T33)
    if (_T34 == 0) branch _L16
    _T35 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T35
    call _PrintString
    call _Halt
_L16:
    _T36 = 4
    _T37 = (_T36 * _T32)
    _T38 = (_T36 + _T37)
    parm _T38
    _T39 =  call _Alloc
    *(_T39 + 0) = _T32
    _T40 = 0
    _T39 = (_T39 + _T38)
_L17:
    _T38 = (_T38 - _T36)
    if (_T38 == 0) branch _L18
    _T39 = (_T39 - _T36)
    *(_T39 + 0) = _T40
    branch _L17
_L18:
    _T41 = 0
    *(_T39 + 4) = _T41
    _T42 = 0
    *(_T39 + 8) = _T42
    *(_T39 + 4) = _T20
    _T43 = 0
    *(_T39 + 8) = _T43
    _T44 = *(_T39 + 4)
    _T45 = *(_T39 + 8)
    _T46 = *(_T28 + 4)
    _T47 = *(_T28 + 8)
    _T48 = 3
    _T49 = 0
    _T50 = (_T48 < _T49)
    if (_T50 == 0) branch _L19
    _T51 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T51
    call _PrintString
    call _Halt
_L19:
    _T52 = 4
    _T53 = (_T52 * _T48)
    _T54 = (_T52 + _T53)
    parm _T54
    _T55 =  call _Alloc
    *(_T55 + 0) = _T48
    _T56 = 0
    _T55 = (_T55 + _T54)
_L20:
    _T54 = (_T54 - _T52)
    if (_T54 == 0) branch _L21
    _T55 = (_T55 - _T52)
    *(_T55 + 0) = _T56
    branch _L20
_L21:
    _T57 = 0
    *(_T55 + 4) = _T57
    _T58 = 0
    *(_T55 + 8) = _T58
    _T59 = (_T44 + _T46)
    *(_T55 + 4) = _T59
    _T60 = (_T45 + _T47)
    *(_T55 + 8) = _T60
    _T61 = *(_T55 + 4)
    *(_T13 + 4) = _T61
    _T62 = *(_T55 + 8)
    *(_T13 + 8) = _T62
    if (_T5 == 0) branch _L22
    _T63 = 5
    _T64 = (_T3 * _T63)
    _T3 = _T64
_L22:
    parm _T5
    call _PrintBool
    _T65 = " "
    parm _T65
    call _PrintString
    parm _T3
    call _PrintInt
}

