VTABLE(_Mac) {
    <empty>
    Mac
    _Mac.Crash;
}

VTABLE(_Main) {
    <empty>
    Main
}

FUNCTION(_Mac_New) {
memo ''
_Mac_New:
    _T4 = 12
    parm _T4
    _T5 =  call _Alloc
    _T6 = 0
    *(_T5 + 4) = _T6
    *(_T5 + 8) = _T6
    _T7 = VTBL <_Mac>
    *(_T5 + 0) = _T7
    return _T5
}

FUNCTION(_Main_New) {
memo ''
_Main_New:
    _T8 = 4
    parm _T8
    _T9 =  call _Alloc
    _T10 = VTBL <_Main>
    *(_T9 + 0) = _T10
    return _T9
}

FUNCTION(_Mac.Crash) {
memo '_T0:4 _T1:8 _T2:12 _T3:16'
_Mac.Crash:
    _T11 = *(_T0 + 8)
    *(_T0 + 8) = _T1
    _T12 = *(_T0 + 4)
    *(_T0 + 4) = _T2
    _T13 = *(_T0 + 8)
    parm _T13
    call _PrintInt
    _T14 = "\n"
    parm _T14
    call _PrintString
    parm _T3
    call _PrintInt
    _T15 = "\n"
    parm _T15
    call _PrintString
    _T16 = *(_T0 + 4)
    _T17 = *(_T16 + 4)
    parm _T17
    call _PrintInt
    _T18 = "+"
    parm _T18
    call _PrintString
    _T19 = *(_T16 + 8)
    parm _T19
    call _PrintInt
    _T20 = "j"
    parm _T20
    call _PrintString
}

FUNCTION(main) {
memo ''
main:
    _T22 =  call _Mac_New
    _T21 = _T22
    _T23 = 2
    _T24 = 3
    _T25 = 3
    _T26 = 0
    _T27 = (_T25 < _T26)
    if (_T27 == 0) branch _L12
    _T28 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T28
    call _PrintString
    call _Halt
_L12:
    _T29 = 4
    _T30 = (_T29 * _T25)
    _T31 = (_T29 + _T30)
    parm _T31
    _T32 =  call _Alloc
    *(_T32 + 0) = _T25
    _T33 = 0
    _T32 = (_T32 + _T31)
_L13:
    _T31 = (_T31 - _T29)
    if (_T31 == 0) branch _L14
    _T32 = (_T32 - _T29)
    *(_T32 + 0) = _T33
    branch _L13
_L14:
    _T34 = 0
    *(_T32 + 4) = _T34
    _T35 = 4
    *(_T32 + 8) = _T35
    _T36 = 3
    _T37 = 0
    _T38 = (_T36 < _T37)
    if (_T38 == 0) branch _L15
    _T39 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T39
    call _PrintString
    call _Halt
_L15:
    _T40 = 4
    _T41 = (_T40 * _T36)
    _T42 = (_T40 + _T41)
    parm _T42
    _T43 =  call _Alloc
    *(_T43 + 0) = _T36
    _T44 = 0
    _T43 = (_T43 + _T42)
_L16:
    _T42 = (_T42 - _T40)
    if (_T42 == 0) branch _L17
    _T43 = (_T43 - _T40)
    *(_T43 + 0) = _T44
    branch _L16
_L17:
    _T45 = 0
    *(_T43 + 4) = _T45
    _T46 = 0
    *(_T43 + 8) = _T46
    *(_T43 + 4) = _T24
    _T47 = 0
    *(_T43 + 8) = _T47
    _T48 = *(_T43 + 4)
    _T49 = *(_T43 + 8)
    _T50 = *(_T32 + 4)
    _T51 = *(_T32 + 8)
    _T52 = 3
    _T53 = 0
    _T54 = (_T52 < _T53)
    if (_T54 == 0) branch _L18
    _T55 = "Decaf runtime error: Cannot create negative-sized array\n"
    parm _T55
    call _PrintString
    call _Halt
_L18:
    _T56 = 4
    _T57 = (_T56 * _T52)
    _T58 = (_T56 + _T57)
    parm _T58
    _T59 =  call _Alloc
    *(_T59 + 0) = _T52
    _T60 = 0
    _T59 = (_T59 + _T58)
_L19:
    _T58 = (_T58 - _T56)
    if (_T58 == 0) branch _L20
    _T59 = (_T59 - _T56)
    *(_T59 + 0) = _T60
    branch _L19
_L20:
    _T61 = 0
    *(_T59 + 4) = _T61
    _T62 = 0
    *(_T59 + 8) = _T62
    _T63 = (_T48 + _T50)
    *(_T59 + 4) = _T63
    _T64 = (_T49 + _T51)
    *(_T59 + 8) = _T64
    _T65 = 5
    parm _T21
    parm _T23
    parm _T59
    parm _T65
    _T66 = *(_T21 + 0)
    _T67 = *(_T66 + 8)
    call _T67
}

